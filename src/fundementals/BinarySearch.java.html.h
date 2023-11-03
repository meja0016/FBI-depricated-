<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang = "en">

<head>

<link rel="shortcut icon" href="https://algs4.cs.princeton.edu/favicon.ico">
<link rel="stylesheet"    href="https://algs4.cs.princeton.edu/java.css" type="text/css">

<title>BinarySearch.java</title>

<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<meta NAME="AUTHOR" CONTENT="Robert Sedgewick and Kevin Wayne">
<meta NAME="DESCRIPTION" CONTENT="BinarySearch code in Java">
<meta NAME="TITLE" CONTENT="BinarySearch code in Java">
<meta NAME="KEYWORDS" CONTENT="BinarySearch,java,programming,computer science,algorithm,data structure,program,code">
<meta NAME="ROBOTS" CONTENT="INDEX,FOLLOW">

</head>


<body>
<center><h1>BinarySearch.java</h1></center><p><br>

Below is the syntax highlighted version of <a href = "BinarySearch.java">BinarySearch.java</a>
from <a href = "https://algs4.cs.princeton.edu/11model">&#167;1.1 Programming Model</a>.
<p><br>

<!-- Generator: GNU source-highlight 3.1.8
by Lorenzo Bettini
http://www.lorenzobettini.it
http://www.gnu.org/software/src-highlite -->
<pre><tt><span class="comment">/******************************************************************************</span>
<span class="comment"> *  Compilation:  javac BinarySearch.java</span>
<span class="comment"> *  Execution:    java BinarySearch allowlist.txt &lt; input.txt</span>
<span class="comment"> *  Dependencies: In.java StdIn.java StdOut.java</span>
<span class="comment"> *  Data files:   </span><span class="url">https://algs4.cs.princeton.edu/11model/tinyAllowlist.txt</span>
<span class="comment"> *                </span><span class="url">https://algs4.cs.princeton.edu/11model/tinyText.txt</span>
<span class="comment"> *                </span><span class="url">https://algs4.cs.princeton.edu/11model/largeAllowlist.txt</span>
<span class="comment"> *                </span><span class="url">https://algs4.cs.princeton.edu/11model/largeText.txt</span>
<span class="comment"> *</span>
<span class="comment"> *  % java BinarySearch tinyAllowlist.txt &lt; tinyText.txt</span>
<span class="comment"> *  50</span>
<span class="comment"> *  99</span>
<span class="comment"> *  13</span>
<span class="comment"> *</span>
<span class="comment"> *  % java BinarySearch largeAllowlist.txt &lt; largeText.txt | more</span>
<span class="comment"> *  499569</span>
<span class="comment"> *  984875</span>
<span class="comment"> *  295754</span>
<span class="comment"> *  207807</span>
<span class="comment"> *  140925</span>
<span class="comment"> *  161828</span>
<span class="comment"> *  [367,966 total values]</span>
<span class="comment"> *</span>
<span class="comment"> ******************************************************************************/</span>

<span class="preproc">import</span><span class="normal"> java</span><span class="symbol">.</span><span class="normal">util</span><span class="symbol">.</span><span class="normal">Arrays</span><span class="symbol">;</span>

<span class="comment">/**</span>
<span class="comment"> *  The {</span><span class="type">@code</span><span class="comment"> BinarySearch} class provides a static method for binary</span>
<span class="comment"> *  searching for an integer in a sorted array of integers.</span>
<span class="comment"> *  </span><span class="keyword">&lt;p&gt;</span>
<span class="comment"> *  The </span><span class="keyword">&lt;em&gt;</span><span class="comment">indexOf</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> operations takes logarithmic time in the worst case.</span>
<span class="comment"> *  </span><span class="keyword">&lt;p&gt;</span>
<span class="comment"> *  For additional documentation, see </span><span class="keyword">&lt;a</span><span class="normal"> </span><span class="type">href</span><span class="symbol">=</span><span class="string">"https://algs4.cs.princeton.edu/11model"</span><span class="keyword">&gt;</span><span class="comment">Section 1.1</span><span class="keyword">&lt;/a&gt;</span><span class="comment"> of</span>
<span class="comment"> *  </span><span class="keyword">&lt;i&gt;</span><span class="comment">Algorithms, 4th Edition</span><span class="keyword">&lt;/i&gt;</span><span class="comment"> by Robert Sedgewick and Kevin Wayne.</span>
<span class="comment"> *</span>
<span class="comment"> *  </span><span class="type">@author</span><span class="comment"> Robert Sedgewick</span>
<span class="comment"> *  </span><span class="type">@author</span><span class="comment"> Kevin Wayne</span>
<span class="comment"> */</span>
<span class="keyword">public</span><span class="normal"> </span><span class="keyword">class</span><span class="normal"> </span><span class="classname">BinarySearch</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * This class should not be instantiated.</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="function">BinarySearch</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal"> </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Returns the index of the specified key in the specified array.</span>
<span class="comment">     *</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment">  a the array of integers, must be sorted in ascending order</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment">  key the search key</span>
<span class="comment">     * </span><span class="type">@return</span><span class="comment"> index of key in array {</span><span class="type">@code</span><span class="comment"> a} if present; {</span><span class="type">@code</span><span class="comment"> -1} otherwise</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">int</span><span class="normal"> </span><span class="function">indexOf</span><span class="symbol">(</span><span class="type">int</span><span class="symbol">[]</span><span class="normal"> a</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="normal"> key</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> lo </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> hi </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">length </span><span class="symbol">-</span><span class="normal"> </span><span class="number">1</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">lo </span><span class="symbol">&lt;=</span><span class="normal"> hi</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="comment">// Key is in a[lo..hi] or not present.</span>
<span class="normal">            </span><span class="type">int</span><span class="normal"> mid </span><span class="symbol">=</span><span class="normal"> lo </span><span class="symbol">+</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">hi </span><span class="symbol">-</span><span class="normal"> lo</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">/</span><span class="normal"> </span><span class="number">2</span><span class="symbol">;</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal">      </span><span class="symbol">(</span><span class="normal">key </span><span class="symbol">&lt;</span><span class="normal"> a</span><span class="symbol">[</span><span class="normal">mid</span><span class="symbol">])</span><span class="normal"> hi </span><span class="symbol">=</span><span class="normal"> mid </span><span class="symbol">-</span><span class="normal"> </span><span class="number">1</span><span class="symbol">;</span>
<span class="normal">            </span><span class="keyword">else</span><span class="normal"> </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">key </span><span class="symbol">&gt;</span><span class="normal"> a</span><span class="symbol">[</span><span class="normal">mid</span><span class="symbol">])</span><span class="normal"> lo </span><span class="symbol">=</span><span class="normal"> mid </span><span class="symbol">+</span><span class="normal"> </span><span class="number">1</span><span class="symbol">;</span>
<span class="normal">            </span><span class="keyword">else</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> mid</span><span class="symbol">;</span>
<span class="normal">        </span><span class="cbracket">}</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="symbol">-</span><span class="number">1</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Returns the index of the specified key in the specified array.</span>
<span class="comment">     * This function is poorly named because it does not give the </span><span class="keyword">&lt;em&gt;</span><span class="comment">rank</span><span class="keyword">&lt;/em&gt;</span>
<span class="comment">     * if the array has duplicate keys or if the key is not in the array.</span>
<span class="comment">     *</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment">  key the search key</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment">  a the array of integers, must be sorted in ascending order</span>
<span class="comment">     * </span><span class="type">@return</span><span class="comment"> index of key in array {</span><span class="type">@code</span><span class="comment"> a} if present; {</span><span class="type">@code</span><span class="comment"> -1} otherwise</span>
<span class="comment">     * </span><span class="type">@deprecated</span><span class="comment"> Replaced by {</span><span class="type">@link</span><span class="comment"> #indexOf(int[], int)}.</span>
<span class="comment">     */</span>
<span class="normal">    @Deprecated</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">int</span><span class="normal"> </span><span class="function">rank</span><span class="symbol">(</span><span class="type">int</span><span class="normal"> key</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="symbol">[]</span><span class="normal"> a</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="function">indexOf</span><span class="symbol">(</span><span class="normal">a</span><span class="symbol">,</span><span class="normal"> key</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">/**</span>
<span class="comment">     * Reads in a sequence of integers from the allowlist file, specified as</span>
<span class="comment">     * a command-line argument; reads in integers from standard input;</span>
<span class="comment">     * prints to standard output those integers that do </span><span class="keyword">&lt;em&gt;</span><span class="comment">not</span><span class="keyword">&lt;/em&gt;</span><span class="comment"> appear in the file.</span>
<span class="comment">     *</span>
<span class="comment">     * </span><span class="type">@param</span><span class="comment"> args the command-line arguments</span>
<span class="comment">     */</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">main</span><span class="symbol">(</span><span class="normal">String</span><span class="symbol">[]</span><span class="normal"> args</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>

<span class="normal">        </span><span class="comment">// read the integers from a file</span>
<span class="normal">        </span><span class="usertype">In</span><span class="normal"> in </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">In</span><span class="symbol">(</span><span class="normal">args</span><span class="symbol">[</span><span class="number">0</span><span class="symbol">]);</span>
<span class="normal">        </span><span class="type">int</span><span class="symbol">[]</span><span class="normal"> allowlist </span><span class="symbol">=</span><span class="normal"> in</span><span class="symbol">.</span><span class="function">readAllInts</span><span class="symbol">();</span>

<span class="normal">        </span><span class="comment">// sort the array</span>
<span class="normal">        Arrays</span><span class="symbol">.</span><span class="function">sort</span><span class="symbol">(</span><span class="normal">allowlist</span><span class="symbol">);</span>

<span class="normal">        </span><span class="comment">// read integer key from standard input; print if not in allowlist</span>
<span class="normal">        </span><span class="keyword">while</span><span class="normal"> </span><span class="symbol">(!</span><span class="normal">StdIn</span><span class="symbol">.</span><span class="function">isEmpty</span><span class="symbol">())</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="type">int</span><span class="normal"> key </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readInt</span><span class="symbol">();</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">BinarySearch</span><span class="symbol">.</span><span class="function">indexOf</span><span class="symbol">(</span><span class="normal">allowlist</span><span class="symbol">,</span><span class="normal"> key</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">==</span><span class="normal"> </span><span class="symbol">-</span><span class="number">1</span><span class="symbol">)</span>
<span class="normal">                StdOut</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="normal">key</span><span class="symbol">);</span>
<span class="normal">        </span><span class="cbracket">}</span>
<span class="normal">    </span><span class="cbracket">}</span>
<span class="cbracket">}</span>
</tt></pre>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-10811519-2");
pageTracker._trackPageview();
} catch(err) {}</script>

</body>

<p><br><address><small>
Copyright &copy; 2000&ndash;2019, Robert Sedgewick and Kevin Wayne.
<br>Last updated: Thu Aug 11 07:59:46 EDT 2022.
</small></address>

</html>
