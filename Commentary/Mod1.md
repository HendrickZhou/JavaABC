#  Introduction to the Java Programming Language

## 1.1 **Prologue**

When writing a program, especially in the Internet age, there are several factors that determine its success. Since the Internet is composed of a variety of operating systems and platforms, a program is expected to run on most of them flawlessly. Also, a program should be robust -- it should allow the user to be productive by not crashing. Another big issue is security. Since programs can come from anywhere or anyone, a certain amount of security control is now necessary.

A key to a program's usability is its portability or the ability to have it run on multiple platforms. Imagine writing a program in a language such as C or C++, the most widely used computer languages prior to Java. Chances are this program will run only on one type of machine or platform. If you want your program to be used by as large an audience as possible, you will want to make it portable. C code is compiled or translated from what the programmer writes into a stream of machine-specific instructions that a specific microprocessor can understand. Thus, a C program that is targeted for the Unix platform will not run on a Windows machine. While not impossible, making C code portable is time-consuming and difficult. It will require specific code changes for each platform. This results in increased complexity as the code grows significantly.

Complex code is often not robust or bug free. It often behaves in an erratic fashion that could possibly cause damage. Who has not experienced running a program with bugs? Just when you are about to save your work, the program freezes, forcing a reboot of the machine. Often, the work you had just performed is lost. In C and C++, the use of pointers contributes greatly to this problem. A pointer is a language construct that lets the contents of one variable "point" to another piece of data. Bugs in pointers can cause the program to crash, or at worst can cause the entire computer to crash, sometimes with permanent loss of data.

In addition to not being robust, a program may over step its bounds and do things that are unauthorized. When you have widely distributed applications, many programs come from unknown sources. Without any assurances, a user should be rightfully concerned about a program's behavior. C and C++ do not enforce security and are given free reign on a machine. Without restrictions, it is very easy to write viruses and other destructive programs. For example, it would be fairly simple to create a program that sends your private files such as your tax returns to a hacker without your knowledge. Another example is a game that is actually a disguised virus that reformats your hard drive. Security features built into a language prevent this kind of horseplay and ease the user's mind.



## **1.2: Enter Oak**

None of these scenarios are unfamiliar to most computer professionals. The first three problems portability, maintainability, and safety have been the bugbears of software engineering since shortly after the invention of the computer. The security problem is somewhat newer, appearing with the personal computer revolution in the late seventies and really blossoming in the age of the Internet.

Over the years, there have been many attempts to deal with these problems, and huge advances have been made. Oracle/Sun Microsystems' Java programming language represents the latest and greatest advance in this long evolution. It adds other innovations in the bargain, but in the end it is Java's combination of solutions to the above-mentioned Big Four problems that makes it so exciting.

### Where did Java come from?

Legend has it that James Gosling and his research group, working at Oracle/Sun's Sun Laboratories division, were investigating "small, reliable, safe, long-lived, portable, real-time, distributed systems." In fewer words, they were thinking about a kind of Internet, a network of computer-enhanced consumer appliances in your house that could coordinate everything from climate control to interactive entertainment. Although this home Internet did not materialize, one offshoot of this research would be a new computer language, originally named Oak, in which the devices were to be programmed.

The language being sought needed the four characteristics we have already noted as often lacking:

**Portability**. Small programs written in this language would be sent around the network from device to device. Therefore, Oak programs needed to be literally portable: it had to be possible to run the same executable code on many different pieces of hardware. It would also help if the computer language could easily handle human languages other than English. (C++'s dependence on the 8-bit ASCII character set causes problems even in Europe, let alone in Asia.)

**Maintainability**. The language had to be small and the code easy to read, so that software could easily be shared among device manufacturers. Furthermore, it had to be easy to determine the relationships between different chunks of code: how else would you know which chunks needed to travel together over the network? Still, it needed to be both powerful and familiar. Ideally, it would be very similar to an established language such as C or C++.

**Safety**. Erroneous code running on the Internet couldn't be allowed to interrupt the normal functioning of any devices. If the furnace crashed, or the pay-per-view system went down, serious economic or other consequences could ensue. Devices would need protection against stray pointer damage.

**Security**. Internet viruses could spell disaster. Perhaps more importantly, they could steal cable TV! As a result, there had to be strong security controls on what a particular section of Oak code would be allowed to do.

Oak answered each of these requirements directly. First of all, it was decided that Oak code would be compiled not into hardware-specific instructions for any real computer, but into instructions for a virtual machine. The Oak virtual machine is a simulated computer, not a real one. If you write programs to simulate the Oak virtual machine on every one of the world's real computers, then compiled Oak code could run on every one of them by running inside the simulation! The simulation hides the differences between the real computers it might be running on, making all machines look the same from the perspective of the Oak program. This makes Oak code completely portable.

Oak source code, as well as text processed by the Oak input/output libraries, is represented in 16-bit Unicode. Unicode is a character set with enough bits to represent almost all of the world's human languages.

The Oak language is designed for ease of code maintenance. First of all, a given variable can hold only one kind of information, so there is less confusion (this is called strong typing, and it will be one of the central themes of this course.) Secondly, functions don't do arbitrary, inappropriate tasks. This is achieved through encapsulation, another important theme of our course. With encapsulation, functions work only within the data defined in an object. This leads to more predictability and less side effects. Oak is very similar to C++, which makes it easy for many practicing C and C++ programmers to learn. (James Gosling has been quoted as saying that "Java is C++ without guns or knives," referring to its resemblance to C++ but with all the parts that can hurt you removed.)

Oak is safe primarily because the dangerous notion of pointers does not exist. There is no use of memory addresses, so it is impossible to refer to a random address! Oak also removes a number of C++'s other dangerous elements, most importantly, many ambiguities in the language definition. In Oak, nothing is "implementation dependent" or "undefined"; in the C and C++ language standards, by contrast, these phrases appear with great frequency.

And Oak is extremely secure, because the Oak virtual machine can be controlled in a way no physical computer can. Want to forbid all Oak programs from writing to your hard disk? Just replace the disk access code in the Oak virtual machine with code to post an error message. Want to prohibit Oak programs from using your computer's network card? Insert similar vetoing code into the Oak virtual machine. Want to allow access for some Oak programs and not for others? Add a dialog box and let the user configure access permissions on a case-by-case basis.

Furthermore, the Oak virtual machine is very picky about the code it runs. Before any code is executed, the virtual machine performs a number of checks on it to make sure that, for example, all local variables are initialized before use, and the machine stack can never be overrun. Then at run time, the virtual machine continually checks for such things as out-of-bounds array access.

While the envisioned market for the home Internet technology did not materialize, Oracle/Sun soon deployed the Oak language in another context: in a World Wide Web browser called HotJava.



## **1.3: The World Wide Web**

I think many journalists would still be surprised to learn that the Internet has existed in one form or another since the late 1960s, beginning as a government research project on computer networks that would degrade gracefully when individual machines were lost. Certainly every company whose advertisement announces "Find us on the Internet at USEDCARS.COM" appreciates the media's portrayal of the World Wide Web as the raison d'etre of the Internet.

It is perhaps more surprising still that the World Wide Web, that most commercial corner of today's Internet, was itself the invention of a small group of particle physicists at CERN, the European particle physics laboratory. The WWW was originally developed in 1989 as a mechanism for those same physicists to publish and share late-breaking data with their peers, and within a year or two was in common use at European universities. In 1993, a group of graduate students at the National Center for Supercomputing Applications (in Illinois) wrote the first graphical WWW browser, named Mosaic, and released free versions for the IBM PC, the Macintosh, and UNIX systems. By late 1994, WWW traffic had surpassed all other Internet usage, and the Wall Street Journal finally noticed the **25-year-old** "novelty" called the Internet.

It was in the spring of 1995 that Sun Microsystems (now an Oracle acquisition) released its first public development version of HotJava, a graphical WWW browser written entirely in Oak--which was renamed Java in the wake of a last-minute copyright search. Acceptance of HotJava was hampered by the rapid development of the Java language itself, which left much of the original HotJava code obsolete soon after its release. But in the fall of 1995, Java was introduced to the public at large, when version 2.0 of the Netscape browser, including Java support, was released (Netscape 1.0 was largely a commercial version of NCSA Mosaic).

Netscape 2.0 supported the embedding of Java applets in a WWW page. An applet is bit of code meant to be embedded inside a larger application. The portability and safety of Java meant that these applets could be written and compiled once, and could then be sent over the WWW to many different kinds of computers for execution. Netscape was instrumental in perfecting versions of the Java virtual machine program that would run on the Macintosh as well as on many flavors of UNIX besides Sun's own Solaris.

While Java's portability, safety, and security make it an ideal language for writing applets, it is important to keep in mind that Java is also a full-fledged applications development language, and that the first WWW browser to support embedded applets (HotJava) was itself written entirely in Java. Although most programmers' first exposure to Java is in the form of WWW applets, it is as an applications language that Java's promise is fully realized.

During this course, remember that Java's association with the World Wide Web and Netscape was purely happenstance; do not consider Java only an applet development language.



## **1.4: Introducing the Java Programming Language**

At the single-line level, Java code looks a lot like its closest relatives, C and C++:

```java
 int i, sum=0;
 for (i=1; i<=10; i++) 
 { 
   sum = sum + i; 
 }
```

computes the sum of the numbers from 1 to 10 in any of Java, C, or C++. If you're not a C programmer, you need to know that the curly brackets delimit blocks of code in the same way that sub ... end sub do in Visual Basic or begin... end do in Pascal. i and sum are variables that can hold integers (actually, C allows them to hold virtually anything; but by default, it's integers). The for(...) construct tells the computer to perform the block of code ten times, setting the value of the counter variable i successively to each of the values starting at 1 and up to and including 10. At the end, sum contains the sum of 1 through 10, or 55.

When we look at an entire program, some structural differences between Java and C are apparent on a slightly larger scale. Here is the code above embedded in a complete C program:

```java
#include <stdio.h>

int main(int argc, char ** argv) 
{ 
    int i, sum=0;
    for (i=1; i<=10; i++)
    { 
        sum = sum + i; 
    } 
    printf("The sum of 1 through 10 is %d\n", 
           sum);   
    return 0; 
}
```

Every C program contains a function called main, which is always the first function to be called in the program. The declaration above says that when main is called, it expects two parameters: an integer (which should contain the number of arguments the program was passed when it was started from a command line) and a list of character strings, each one of which should contain one of those command line arguments. When our loop completes, this program prints the result using the C printf function, then uses the return keyword to exit the function and hence the program.

Here is the same code fragment cast as a complete Java program (your first!):

```java
public class SumOneToTen 
{ 
   public static void main(String[] argv) 
   {
     int i, sum=0;
     for (i=1; i<=10; i++) 
       {
         sum = sum + i; 
       }
       
       System.out.println("The sum of " +
                        "1 through 10 is " + 
                        sum);
   } 
}
```

There are a number of differences between these two programs. Some of them are pretty important, although you won't be in a position to understand why until we've gotten a bit further along.



**Classes**

The most obvious difference between the two programs is that outer set of brackets and the mysterious incantation public class SumOneToTen. In Java, every function and variable is inside such a declaration, called in general a *class*. Eventually we'll see that classes are really the cornerstone of maintainability in Java programming. For now, it's enough for you to know that you have to use one. Furthermore, for most Java development tools, the name of the class (SumOneToTen) must correspond to the name of the file in which you write this code (SumOneToTen.java), including the case. Neither SUMONETOTEN.java nor sumonetoten.java will do; even though some operating systems would consider all three of these names to refer to the same file, the JDK Java compiler and the JDK Java runtime consider case to be significant in file names. If you're not using the JDK, see the documentation for your own Java development environment for details about file names.



## **1.5: The Function 'main'**

Every Java application contains a function declared as public static void main(String [] argv). This serves the same purpose as C's main function, but with some differences. First of all, Java's main does not return a status value to its environment. (That's what void means: no value, like the normal English meaning "empty.") The second difference is more interesting. While C's main needs two parameters to describe the command-line arguments, Java's main needs only one. This is because in C there is no way to know how long the list argv is without passing the length as a separate parameter. In Java, however, lists (or more properly, *arrays*) are *self-describing.* You can literally ask the list of arguments how long it is, making the argc parameter redundant. For example, in the program above, we could change the line

```
 for (i=1; i<=10; i++)
```

to

```
 for (i=1; i<=argv.length; i++)
```

This would sum the integers (1 ... <number of arguments>) instead of (1 ... 10). This self-describing property of arrays is the first glimmer of what we'll soon see to be a very important design principle in Java.

public and static are pretty interesting too, but we won't discuss these yet.



## **1.6: Method Calls**

In the C program, we can just call the function printf to print our results. But in Java, as we said above, all functions are inside of classes. To call a function, we must refer to the class the function occurs in (this is a little white lie, actually, as you'll see soon enough!). Hence we cannot just call println; we must call System.out.println. One upshot of this is that a single program can have many functions named println; if they occur in separate classes, it's very easy to tell which one you mean. In languages where functions belong to classes, they are often termed *methods*



## **1.7: A Word about Code Format**

As trivial as it may seem, the physical layout of your code on a printed page can help enormously with code maintenance. We'll talk about conventions for formatting your code during the course, but right now I want to point out a few features of the program above.

First of all, indentation and placement of braces is consistent. It is more important that you pick a style and stick to it than it is that you use any one particular style. I favor a style in which matching opening and closing braces appear vertically in line with one another, and enclosed code is indented by two spaces relative to the braces. Pick your own preferences, but be consistent!

Second, the first lines of class and method declarations in my code contain all the qualifiers (public static void), while the actual name of the class or method is on the following line. This places the important names at the left margin, where they are more easily found.

Third, virtually all Java programers use names starting with lower case letters for variables and functions, while classes get uppercased names, with any internal word boundaries also marked with uppercase letters. For example, thisIsAVariableName and ThisIsAClassName. The Java APIs themselves use this convention.

