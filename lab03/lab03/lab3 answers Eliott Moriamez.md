**2) throws, throw, try-catch, try-finally, and try-catch-finally**
1. Checked exceptions are checked at compile time: must be declared (throws) or caught.\
Unchecked (RuntimeException/Error) are checked at runtime, no compile-time requirement
2. throw: used inside method body to actually throw an exception instance. e.g. throw new IOException("msg");\
throws: used in method declaration to declare that the method may throw certain checked exceptions. e.g. void foo() throws IOException

**6) Simple File I/O: binary files**
1. - BufferedReader/BufferedWriter: text buffering for readers/writers.
- FileReader/FileWriter: basic character stream for files.
- PrintWriter: convenient printing of formatted strings.
- FileInputStream/FileOutputStream: byte streams for binary data.
- DataInputStream/DataOutputStream: read/write Java primitive types in binary form.
- ObjectInputStream/ObjectOutputStream: serialize/deserialize objects (implements Serializable)
- Files: utility methods (readAllBytes, readAllLines, newBufferedReader, newBufferedWriter).