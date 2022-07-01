# **Basic Programming Using Java**

## **2.1: Prologue **

Learning a new programming language seems always to proceed in two stages. In the first stage, everything is unfamiliar. You're learning the basic details of language syntax, typing different things and wondering whether they'll compile, figuring out how to express simple concepts in this clumsy new system of strange terminology and odd-looking punctuation. Nobody enjoys this first stage, because nobody likes to feel awkward. If you've ever taken lessons on a musical instrument, learned a foreign language, or taken up jogging or skiing for exercise, you're familiar with this phase. Early in the learning process, you need to concentrate hard on the details, and you're never sure if you're doing the right thing. It's because of this awkward stage that many endeavors of this sort fail.

But if you persevere, you eventually reach the second stage, which is hugely rewarding. In this stage, the basic skills (reading sheet music, stopping and turning on skis, conjugating your verbs) have become automatic. You no longer have to think about them. Then you can concentrate on the good stuff: expressing emotion via a beautiful tone from your violin; watching the scenery or racing downhill; discussing the nose of a Bordeaux in a cafe on the Champs Elysees; writing solid, dependable code that you can be proud of.

This course note is intended to get you through the awkward first stage as quickly and painlessly as possible, so you can be playing a symphony before you know it.



## **2.2: The Basics of Java Syntax **

**Strong Typing**

The most important feature of Java, and the one that distinguishes it from most other programming languages you may have used, is that it is a very *strongly typed language*. What this means is that

1. Every Java variable must be declared before use;
2. Every Java variable can hold a value of one specific data type only; and
3. The specific type is part of the declaration.

Java is more strongly typed than Visual Basic (of course), or C or C++. Java's type system is comparable to Pascal's. This means that although the following is perfectly valid in C, C++, or (conceptually) in Visual Basic,

```
int i = 3.2;
```

a Java compiler will produce

```
 test.java:4: Incompatible type for =. Explicit cast needed to convert double to int. 
 i = 3.2; 
   ^ 1 error
```

because the number 3.2 is *not* a valid integer. To make this code acceptable to the compiler (though in this case it's not clear why you'd want to!) you can use a *cast*, which looks like this:

```
 int i = (int) 3.2;
```

The parenthetical type name tells the compiler to convert 3.2 to an integer before the assignment; it will do so by dropping the fractional part. There are limits to how much you can accomplish with a cast, however. In C or C++, this is perfectly valid:

```
 int i = (int) "Hello, World!";
```

but there is absolutely no way to force a Java compiler to accept it. One very useful result of this is that anytime you see a variable of type "int" you know without a doubt that it contains a number, not a disguised pointer to a character string. Incidentally, the proper variable type to use to refer to a character string in Java is String:

```
 String i = "Hello, World";
```

One interesting example of strong typing in Java is the existence of a basic type called boolean:

```
 boolean fun = true;
```

Boolean variables can contain only the special literal values "true" and "false." Booleans are important because conditionals in Java are of type boolean. In the fragment

```
 if (x < 3) { /* do something */ }
```

the expression (x < 3) is of type boolean, not integer, as it would be in C. As a result, this C programming favorite is an error in Java:

```
 int x; 
 // more code 
 if (x) { /* do this if x is nonzero */ } 
 // syntax error!
```

You have to explicitly do the comparison:

```
 if (x != 0) { /* do this if x is nonzero */ }  
```



 

## **2.3: Functions**

Every function (for Visual Basic programmers: in Java, no distinction is made between functions and subroutines; the generic term "function" is used to refer to both. Actually, you usually say "method" instead, but we're going to call them functions for now!). As I was saying, every function in Java accepts a definite number of arguments of specific, definite types, and returns a value also of some specific type (one possible return type is "void", which means "returns no value"). As we pointed out above, all functions must be qualified by calling them through a variable of an appropriate type:

```
 System.out.println("Hello");
```

means to call the println() function attached to the System.out *object*. These properties of functions are part of Java's strong type system: functions have very definite properties, just like variables.

Your programs can easily define their own functions. Just put them inside the class brackets, but outside the main() function. Consult the text for details.



## **2.4: Comments**

Before we talk about code, I want to mention those little things that go in between your code: programmer's comments. Java supports not one, not two, but three different comment syntaxes. I will describe them here.

First, Java supports Visual Basic-style single-line comments (using the C++ "//" syntax):

```
// This is a comment
   int i = 4; // This is a comment too. 
              //set i to 4.
```

Second, Java also supports C-style "/* ... */" comments, which can span multiple lines:

```
 /*
   A long comment, extending over 
   several lines. 
 */
```

Note that C-style comments do not nest. The following produces a syntax error:

```
 /* 
   /* A shorter comment than we intended: 
    this is the end of the whole comment -> 
   */
 */
```

*Compiler says:*

```
test.java:7: Missing term.
         */ 
          ^
```

It's OK to put C++-style comments inside of C-style comments, however, and vice versa:

```
 /*
   // A perfectly good
   // four-line comment 
 */
```

This suggests an important general style rule: Always use "//" comments within normal code. Use them to comment individual lines, or to document blocks inside of functions. Then, if you ever want to comment out a whole section of code quickly, you can easily use /* ... */ -style comments to do it!

Third, Java supports another type of comment, the "documentation comment," /** which looks like this */. It's a proper subset of C-style comments. Documentation comments are used by tools such as Oracle/Sun's javadoc to automatically document your Java source code. [Javadoc (Links to an external site.)](http://docs.oracle.com/javase/7/docs/technotes/guides/javadoc/index.html) is a useful tool, well worth the small investment of learning how to use it. The [online Java API documentation (Links to an external site.)](http://docs.oracle.com/javase/7/docs/api/) is actually produced from the Java source code by the javadoc tool.



## **2.5: Control Structures**

### for

Java derives its set of control structures from C. If you're familiar with that language, there will be few surprises for you here. Otherwise, I think you'll find that Java's control structures are easy to use and understand. I'm only going to point out a few ways in which these control structures differ from those of C and from Visual Basic.

We saw a use of the for loop already.

```
 int i, j=0; 
 for (i=0; i<10; i++)
    j += i;
```

One nice feature that Java shares with C++ is that you can declare the loop-counter variable (which is used only inside the loop) in the for statement itself:

```
 int j=0; 
 for (int i=0; i<10; i++)
    j += i;
```

In Java, such a loop counter lives only in the scope of the for statement itself. The following code is illegal in Java:

```
 int j=0; 
 for (int i=0; i<10; i++)
    j += i; 
 System.out.println("i is now" + i);
```

*Compiler says:*

```
test.java:8: Undefined variable: i  
   System.out.println("i is now" + i);
                      ^ 
   1 error
```

The equivalent code in Visual Basic or C++ would be perfectly valid.

### switch

The switch statement in C and in Java:

```
 //get value from somewhere
   int j = interestingFunction();
   
   switch(j)
   { 
   case 0:
     doSomething(); break;
   
   case 1: 
      doSomethingElse(); break;

   case 2: 
     doSomethingAltogetherDifferent(); 
     break;

   default: 
     System.out.println("Unexpected j value!"); 
     break;
   }
```

is very similar to the SELECT CASE statement in Visual Basic, with one important difference: in Java and C, the individual cases can "fall through," so that more than one can be executed during a singleswitch statement. That is the purpose of the break statement. If the break statements were removed, in the case of j being equal to 1, both doSomethingElse() and doSomethingAltogetherDifferent() would be executed, and then the error message would be printed! Forgetting the break statements is a major source of errors in the use of switch, so be careful!

### goto

The folks who designed the Java language had a healthy, if dry, sense of humor. Case in point: "goto" is a reserved word in Java, just as it is in C, C++, and Visual Basic. In those languages, it is much reviled as the cause of "spaghetti code." (Anti-goto sentiment, in fact, gave rise to one of the biggest revolutions in programming history, the rise of "structured programming.") In Java, "goto" is reserved, which means that it is not available for use as a variable name, for example; but it is not implemented as a language keyword, either, so effectively the evil "goto" is banished from appearing anywhere in Java code, entirely out of spite! The compiler even knows about it:

```
test.java:14: "goto" not supported. 
    goto foo; 
    ^ 
1 error
 
```

### labeled and break continue

Real programmers know that once in a while the evil "goto" becomes a necessary evil. What do you do in such a case? For example:

```
 for (int i=0; i<10; i++) 
    for (int j=0; j<10; j++) 
       for (int k=0; k<10; k++) 
          for (int m=0; m<10; m++) 
             { 
             if (userCancelled()) 
                // Oh-oh - what do I do? 
             else 
                // do i,j,k,m processing 
 			  }
```

Here a goto would be justified; anything else would make the code harder to understand. In this case, Java supports the notion of labeled breaks:

```
 do_ijkm: 
    for (int i=0; i<10; i++) 
       for (int j=0; j<10; j++) 
          for (int k=0; k<10; k++) 
             for (int m=0; m<10; m++) 
                { 
                if (userCancelled()) 
                   break do_ijkm; 
                else 
                   // do i,j,k,m processing 
                }
```

A break statement like this will halt all the nested loops in progress and exit out the bottom of the labeled one. Similarly, continue statements, which abort the current iteration of a loop and begin the next one, can include a label, so that outer nested loops can be restarted as well.



 

## **2.6: Arrays**

Arrays are a very useful programming tool. A Java array is like a list of variables that all share the same name. You refer to one individual variable by supplying that name plus a number that gives the position in the list:

```
// create an array
int [] myArray = new int[10];
// set the first element to 7
myArray[0] = 7; 
// read the fourth element
int i = myArray[3];       
```

To create an array in Java, you always use the "new" operator, as shown above. "new" is something akin to malloc() in C; Visual Basic's "DIM" statement is a poor cousin. What any of these statements does is to set aside space for a certain number of items in the list (or "elements in the array," to use the proper terminology).

Any array created this way has a definite number of elements in it. What's more, the array knows how many, and you can ask it:

```
System.out.println("myArray has " + 
                    myArray.length + 
                    "elements.");
```

prints "myArray has 10 elements." Note that the first one is named myArray[0], and the last one is myArray[9], for a total of 10 elements. Although this may seem strange to you, depending on what languages you already know, it lets you write loops such as

```
for (int i=0; i<10; i++) 
    System.out.println("myArray[" + i + 
                        "] is " + myArray[i]);
```

without using the uglier >= operator, for example.

If you try to access the eleventh element of myArray:

```
myArray[10] = 0;
```

your programs stops and prints something like

```
java.lang.ArrayIndexOutOfBoundsException: 
          at test.main(test.java:5)
```

This is like what happens in Visual Basic, but unlike what happens in C. C has no runtime checks for this kind of thing, so what generally happens is memory gets corrupted and perhaps the program (eventually) crashes.

It is important to realize that the variable myArray is not the array itself; the variable merely refers to (points to) the array. The array itself is an object, a chunk of memory on the freestore. Any number of variables (including 0) may refer to a given array:

```
int[] arrayA = new int[10];
int[] arrayB = arrayA; 
```

Both variables refer to the same array. If I now assign a value to arrayA[3], I would read the same value from arrayB[3]. I can make neither of these variables refer to that array:

```
arrayA = null;   arrayB = null; 
```

null is a special value in Java which means "no object." Now the array we allocated is unreachable. This is not a memory leak as it would be in C, though. The array is silently recycled by Java; this process is called garbage collection, and we'll discuss it further in a later module.

Note that in Java, if you want to grow an array, the only way to do it is to create a new, bigger array, copy the old data into the new array, and then assign the new one to the old variable:

```
// create an array
int [] temp = new int[20];
System.arraycopy(myArray, 0, temp, 0, myArray.length); 
// assign the new array to the old
myArray = temp;             
```

The System.arraycopy() function (you can look it up in the online API docs) quickly copies the contents of one array into another. It's much faster than the equivalent "for" loop:

```
for (int i=0; i<myArray.length; i++) 
   temp[i] = myArray[i];
```

Notice that assigning directly to the array "myArray" discards the whole list of elements set aside by the original "new" call. The variable myArray now refers to the new storage area allocated by the second "new." Java automatically figures this out and will deallocate the memory if it needs to reuse it.

Note that you can have arrays containing any Java data type, not just integers. For example:

```
String [] s = new String[3]; 
for (int i=0; i<3; i++) 
   s[i] = "foo";
```

You can also initialize arrays using the equivalent shortcut notation:

```
String [] s = { "one", "two", "three" };
```

Note that in Java, multidimensional arrays are actually arrays of arrays. The line

```
int [][] matrix = new int[10][10];
```

allocates a two-dimensional, ten-by-ten array of integers. This one line is exactly equivalent to

```
int [][] matrix = new int[10][]; 
for (int i=0; i<10; i++) 
   matrix[i] = new int[10];
```

You can therefore easily make two-dimensional arrays that are not rectangular:

```java
int [][] triangle= new int[10][];
for (int i=0; i<10; i++) 
   triangle[i] = new int[i];
```



## **2.7: Strings**

Strings in Java are *not* arrays of characters. They are examples of the mystical creatures called "objects" that we briefly encountered last week. They've got a few interesting properties we need to cover now, even though we're putting off talking about objects themselves.

You can create Strings this way:

```
String s = "A lovely String";
```

Strings know how long they are, just like arrays. For Strings, length() is a function:

```
//len gets 15
int len = s.length();
```

Note that a double-quoted character string is a String object too:

```
//len still gets 15
int len = "A lovely String".length();
```

A String variable can refer to no String at all, like this:

```
String no_string = null;
```

"null" is a special literal value, like a "0" pointer in C. It's not the same as an empty String:

```
String emptyString = ""; 
           
// i gets "0"
int i = emptyString.length();
  
String nullString = null;
  
// runtime error!
int j = nullString.length();
```

Another interesting property of Strings is their support for the "+" operator. You can add anything in Java to a String, and the result is a String! For example:

```
int answer = 42; 
String message = "The answer is " + answer;
```

This works if any of the operands of the "+" is a String. Be careful of the following mistake:

```
// oops! 
String s = "Three plus four is " + 3 + 4;
```

s ends up containing "Three plus fours is 34", because the + in 3 + 4 concatenates the numbers to the String rather than adding them.

You can compare two Java strings for equality using the equals() function:

```
String s = "something";
if (s.equals("something else"))
   thisDoesntGetExecuted();
else
   thisDoes(); 
```

Although the syntax for equals() may look odd to you, it should soon seem quite familiar, as all Java functions work the same way. I will say that the equals() function is being called "on" or "through" the String s.

You can compare Strings for alphabetical ordering using compareTo():

```
String a = "Albert Aligator";
if (a.compareTo("Zachary Zebra") < 0)
   thisGetsExecuted();
```

String comes before the second one alphabetically; 0 if they are equal; and greater than one if the first String is alphabetically greater than the second. You can read about both of these functions, and many others, on the API documentation page for java.lang.String.



## **2.8: Basic I/O in Java**

Java supports a very rich and powerful I/O architecture, but to understand it you've got to get some of the concepts of object-oriented programming under your belt. We're still at that awkward stage, so for now, here are a few idioms you can just take for granted that will get you up and running.

System.out.print() and System.out.println() are the workhorse functions for displaying text on the console. They will accept any type of Java data and display it. println() appends a carriage return; print() does not. Given what you know about Strings, you can print just about anything using them:

```
System.out.println(3); // OK
System.out.println(3.2); // OK           
System.out.println("The answer is " + 3.2); // OK
```

Sometimes after you print() something, nothing appears on the screen until you call System.out.flush(). println() doesn't have this "problem."

Understanding input is a bit tougher. You're going to have to take my word for it, but if you want to read lines from the console, you need to do something like this:

```java
// put this at the very top of your file: 
import java.io.*;

// change the first line of main to look like this 
public static void main(String [] argv) throws IOException
{
// then, in your main() function:
BufferedReader stdin =
   new BufferedReader(new InputStreamReader(System.in), 1);

// then, to get a line of user input
//as a string: 
String s = stdin.readLine();

// ... or to read an integer 
int i = Integer.parseInt(stdin.readLine()); 
```



## **2.9: Objects**

One last word about type safety, and one first word about objects. You can define your own data types in Java, just as you can in C or in Visual Basic. In C, you can define structs:

```
typedef struct foo { int x,y,z; }
```

In Visual Basic, you can define TYPEs:

```
Type foo 
    x As Integer 
    y As Integer 
    z As Integer 
end type
```

In Java, you define classes. You can define classes which are just like the "foo" type above:

```
class Foo { int x,y,z; }
```

Then you can, for example, define a function that returns a Foo object:

```java
Foo makeFoo() 
{ 
    Foo f = new Foo();
    f.x = 10;
    f.y = 20;
    f.z = 30;
    return f; 
}
   
```



