# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to IBM for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
from java.lang import String
from java.util import Properties
from com.ibm.ws.scripting import ScriptingException
from java.io import File
from java.io import FileOutputStream
from java.io import FileInputStream
from java.io import PrintStream

#########################################################################################################
#
#  Verify input parameters
#
#########################################################################################################
# Usage method
def usage():
	print ""
	print "Usage to attach bindings:"
	print "wsadmin -lang jython -f bindings.py attach policySetName"
	print "Usage to remove bindings:"
	print "wsadmin -lang jython -f bindings.py remove policySetName"
	sys.exit()

# Init the global variables
action = ""
ischanged = 0
resultOfCall = ""
alreadyattached = 0

# Get the action parameter
try:
	action = sys.argv[0]
except:
	print "You must specify an action, either 'attach' or 'remove'"
	usage()
if (action != "attach") and (action != "remove"):
	print "You must specify an action, either 'attach' or 'remove'"
	usage()

# Get cell type
cell=AdminConfig.list("Cell")
cellType=AdminConfig.showAttribute(cell, "cellType")

# Next get the policy set, node and cell
try:
	myPolicySet = sys.argv[1]
	wasNode = sys.argv[2]
	wasCell = sys.argv[3]
	wasServer = sys.argv[4]
except:
	print 'You must specify a policy set name, server node, server cell and server name.'
	usage()

#########################################################################################################
#
#  Policy set methods
#
#########################################################################################################

# Import the required Policy Set
def importPolicySet(policySetName):
	global resultOfCall, ischanged
	try:
		if (findPolicySet(policySetName)):
			resultOfCall = ""
		else:
			attrs = '-defaultPolicySet "' + policySetName + '"'
			resultOfCall = AdminTask.importPolicySet(attrs)
			print "Imported policy set '"+policySetName+"'"
			ischanged = 1
	except:
		print "Policy Set Already Imported: " + policySetName

# See If The Policy Set Is Already Imported
def findPolicySet(policySetName):
	try:
		policies = AdminTask.listPolicySets()
		if len(policies) != 0:
			iLen = len(policies)
			policy =  policies[0:iLen].splitlines()
			for pol in policy:
				# See if it matches 
				if (pol == policySetName):
					print "Policy set '"+policySetName+"' is already imported"
					return (1==1)
	except:
		print "ERROR: Exception finding policy set"
	return (0==1)

# A method to create a policy set attachment
def createPolicySetAttachment(appName, policySetName, attachmentType, resources):
	global resultOfCall, ischanged
	try:
		attrs = '-applicationName ' + appName + ' -attachmentType ' + attachmentType + ' -policySet "' + policySetName + '" -resources "' + resources + '"'
		resultOfCall = AdminTask.createPolicySetAttachment(attrs)
		print "Attached policy set '"+policySetName+"' to '"+appName+"' ID="+resultOfCall
		ischanged = 1
	except:
		print "ERROR: Exception creating policy set attachment " + policySetName

# A method to set the bindings on an attachment
def setBinding(policyTypeName, appName, psID, attachmentType, bindingName, expectedResult):
	global resultOfCall, ischanged
	try:
		attrs = '-policyType ' + policyTypeName + ' -bindingLocation "[ [application ' + appName + '] [attachmentId ' + psID + '] ]" -attachmentType ' + attachmentType + ' -bindingName ' + bindingName
		resultOfCall = AdminTask.setBinding(attrs)
		print "Attached binding '"+bindingName+"/"+policyTypeName+"' to '"+appName+"'"
		ischanged = 1
	except:
		print "ERROR: Exception setting binding " + bindingName 

# A method to delete a policy set attachment
def deletePolicySetAttachment(appName, polname, aType, allOthers):
	global ischanged, alreadyattached
	found = 0
	try:
		# List all policies attached to specified app
		policies = AdminTask.getPolicySetAttachments('[-applicationName '+appName+' -attachmentType '+aType+']')
		if len(policies) != 0:
			iLen = len(policies) - 1
			policy =  policies[1:iLen].splitlines()
			for pol in policy:
				# See if it matches 
				if ((allOthers == "y") & (pol.find(polname) != -1)):
					print "Policy set '"+polname+"' is already attached to '"+appName+"'"
					alreadyattached = 1
				# See if this one should be detached
				if (polname == "*") | ((allOthers == "y") & (pol.find(polname) == -1)) | ((allOthers == "n") & (pol.find(polname) != -1)):
					attrs = pol.split("[")
					for attr in attrs:
						# parse out the ID
						if attr.find("id") == 0:
							id1 = attr.split(" ")
							id2 = id1[1].split("]")
							# Perform the delete
							AdminTask.deletePolicySetAttachment('[-applicationName '+appName+' -attachmentId '+id2[0]+' -attachmentType '+aType+']')
							print "Deleted policy set ID="+ id2[0] + " from application '"+appName+"'"
							found = 1

		# Print a message if not found
		if 0 == found:
			if allOthers == "n":
				print "Cannot find '"+appName+"' attachment for '"+polname+"'"
		else:
			ischanged = 1

	except:
		print "ERROR: Exception removing policy set "+polname

# A method to force node sync
def forceSync():
	try:
		nodeSyncObjects = AdminControl.queryNames("type=NodeSync,*")
		if len(nodeSyncObjects) > 0:
			nodeSyncObjectList = nodeSyncObjects.splitlines()
			for nodeSync in nodeSyncObjectList:
				result = "false"
				print "nodeSync for " + nodeSync
				try:
					while result != "true":
						print "Force NodeSync ..."
						result = AdminControl.invoke(nodeSync, "sync", "")
						print "Sync result is " + result
				except:
					print "ERROR: AdminControl.invoke(" + nodeSync + ", 'sync', '') exception"
			result = "false"
			while result == "false":
				result = AdminApp.isAppReady('JaxWSServicesSamples')
				print "IsAppReady JaxWSServicesSamples="+result
		else:
			print "Node Sync Not Applicable"
	except:
		print "ERROR: forceSync exception"
		return

# A method to save and restart
def restartApps ():
	global ischanged

	myApplication = "JaxWSServicesSamples"
	try:
		# Save the configuration
		print "Saving configuration ..."
		AdminConfig.save()
		ischanged = 0
	except:
		print "ERROR: Exception saving configuration"

	# Try to sync
	forceSync()

	try:
		# Finally try to restart the applications
		# For standalone, we ignore the process name
		if (cellType == "STANDALONE"):
			print "Restarting application in single server ..."
			appManagerObjects = AdminControl.queryNames('cell='+wasCell+',node='+wasNode+',type=ApplicationManager,*')
		else:
			print "Restarting application in ND ..."
			appManagerObjects = AdminControl.queryNames('cell='+wasCell+',node='+wasNode+',process='+wasServer+',type=ApplicationManager,*')
		if len(appManagerObjects) > 0:
			appManagerList = appManagerObjects.splitlines()
			for appManager in appManagerList:
				AdminControl.invoke(appManager, 'stopApplication', myApplication)
				AdminControl.invoke(appManager, 'startApplication', myApplication)
		else:
			print "ERROR: No ApplicationManager available"
			print "Make sure the cell, node, and server names are correct and the server is started."
	except:
		print "WARNING: Applications may not have restarted correctly."
		print "         Make sure the server is started and use the console to restart the samples."


#########################################################################################################
#
#  Perform the action
#
#########################################################################################################

##################
# Setup bindings #
##################
if action == "attach":

	myApplication = "JaxWSServicesSamples"
	# Remove any existing policy set attachments
	deletePolicySetAttachment(myApplication, myPolicySet, "application", "y")
	deletePolicySetAttachment(myApplication, myPolicySet, "client", "y")

	if 0 == alreadyattached:
		# Make sure the policy set is imported
		importPolicySet(myPolicySet)

		### CREATE ATTACHMENTS ###
		try:

			# Create the policy set application attachment
			createPolicySetAttachment(myApplication, myPolicySet, "application", "WebService:/")
			myAppPolicySetAttachmentID = resultOfCall
	
			# Set the bindings for WS-I RSP
			if myPolicySet == "WS-I RSP":
				# Set the binding for the application attachment
				setBinding("WSSecurity", myApplication, myAppPolicySetAttachmentID, "application", "RAMP_default_bindings", "true")
				setBinding("WSReliableMessaging", myApplication, myAppPolicySetAttachmentID, "application", "RAMP_default_bindings", "true")
	
			# Set the bindings for SecureConversation
			if myPolicySet == "SecureConversation":
				# Set the binding for the application attachment
				setBinding("WSSecurity", myApplication, myAppPolicySetAttachmentID, "application", "SecureConversationServiceBinding", "true")
	
			# Create the policy set client attachment
			createPolicySetAttachment(myApplication, myPolicySet, "client", "WebService:/")
			myClientPolicySetAttachmentID = resultOfCall
	
			# Set the bindings for WS-I RSP
			if myPolicySet == "WS-I RSP":
				# Set the binding for the application attachment
				setBinding("WSSecurity", myApplication, myClientPolicySetAttachmentID, "client", "RAMP_client_default_bindings", "true")
				setBinding("WSReliableMessaging", myApplication, myClientPolicySetAttachmentID, "client", "RAMP_client_default_bindings", "true")
	
				# Set the bindings for SecureConversation
			if myPolicySet == "SecureConversation":
				setBinding("WSSecurity", myApplication, myClientPolicySetAttachmentID, "client", "SecureConversationClientBinding", "true")
	
		except:
			print "ERROR: Setup bindings failed with exception."


###################
# Remove bindings #
###################
if action == "remove":

	myApplication = "JaxWSServicesSamples"
	print "Removing policy set '"+myPolicySet+"' ..."

	# Delete the policy set application attachment
	deletePolicySetAttachment(myApplication, myPolicySet, "application", "n")

	# Delete the policy set client attachment
	deletePolicySetAttachment(myApplication, myPolicySet, "client", "n")


#########################################################################################################
#
#  Finish
#
#########################################################################################################
# Save after the action is done
if 1 == ischanged:
	restartApps()

else:
	AdminConfig.reset()
	print "ERROR:  "+action+" FAILED"
