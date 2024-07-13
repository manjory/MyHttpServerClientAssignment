steps to solve the problem:


Parse Command-line Arguments: Use getopt() to handle options like -d, -h, -l file, -p port, -r dir, -t time, -n threadnum, -s sched.

Initialize the Server:

Create a socket.
Bind it to the specified port.
Set the socket to listen for incoming connections.
Set Up Multithreading:

Create a pool of n execution threads.
Create a queuing thread to accept connections and add them to a ready queue.
Create a scheduling thread to dispatch requests from the queue to the execution threads.
Handle HTTP Requests:

For each connection, read the request.
Parse the request to determine the type (GET or HEAD) and the requested resource.
Formulate the appropriate HTTP response headers.
For GET requests, read the requested file and send its contents.
For HEAD requests, only send the headers.
Directory Handling:

If a directory is requested, check for index.html.
If index.html is not present, generate a directory listing.
Thread Synchronization:

Use mutexes and condition variables to manage access to the ready queue.
Ensure thread-safe access to shared resources.

