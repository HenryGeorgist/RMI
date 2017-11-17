In order to run the example RmiTesting project, the first step is to locate the jdk used to compile the project (jdk18x64), and copy the “rmiregistry.exe” and “jli.dll” files out of the bin directory. Place those in the classes directory of RmiTesting (…\RmiTesting\build\classes)

# Steps

To run the program successfully the following steps must be followed:
1.	Launch rmiregistry.exe (double click on it in the classes directory)
2.	Shift+right click in the classes directory and start a cmd prompt window
3.	Type the following statement into command prompt: 
java –cp . Implementations.Plugin.Producer Producer
4.	Shift+right click in the classes directory and start another cmd prompt window
5.	Type the following statement into command prompt: 
java –cp . Implementations.Plugin.Consumer Consumer
6.	Shift+right click in the classes directory and start a final cmd prompt window
7.	Type the following statement into command prompt: 
java –cp . Implementations.Client.Manager 100

