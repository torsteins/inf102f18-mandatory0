# Mandatory 0
For the course [INF102 Fall 2018](https://mitt.uib.no/courses/12780)

Deadline: September 26, 2018 at 23:59

## Organizational notes

This assignment is an individual task, however you are allowed
to collaborate and discuss solutions *as long as you do not share code*
(see our policy on
[Collaboration and Cheating](https://mitt.uib.no/courses/12780/pages/collaboration-and-cheating)).
Similarily, for tasks which are not answered with code,
you may freely discuss your answers with your peers; but clearly,
blindly transcribing answers from others is not
allowed.

The assignment is graded on a scale from 0 to 100,
and accounts for 10% of your final grade.


#### Forbidden libraries

You may not use any external libraries or classes in
your answers that you did not write yourself.
The only exception to this is Kattio.java
and/or another method for fast input/output in Java; in
these cases, you should clearly mark and attribute
the code correctly. And you are still expected to be able
to explain every single line of what the code does.

You may generally use the Java standard library, but with couple of exceptions:
* Any data structure from the standard library that is used
to provide the functionality of a Collection is forbidden.
This includes (but is not limited to):
  * Set, List, Queue, Stack, Dequeue, Vector, ArrayList, LinkedList, 
 TreeSet, PriorityQueue etc.
* Any data structure from the standard library that is used to
provide the functionality of a Map is forbidden.
This includes (but is not limited to):
  * HashMap, TreeMap, Dictionary, HashTable
* Any algorithm from the standard library which implements a sort
of some kind is forbidden.
This includes (but is not limited to)
  * Arrays.sort()
  
In order to use the funcionalities offered by these data structures and algorithms,
you will need to implement them yourself. This includes any functions used for testing.



## Organizational instructions (30 points)

Getting the organizational instructions right can be astonishingly difficult.
Therefore, we award a whopping 30 points to everyone who manage to follow all of them!

The number of points drop rapidly, though; for every mistake in following the handin
instructions, your points for this category is *cut in half*. Thus, if you make a single
mistake, you lose 15 points! If you make two mistakes, you lose 15 + 7.5 = 22.5 points!
So follow these instructions carefully.

#### Getting started

 * To start working with the mandatory assignment, clone or download this repository to
 your local machine. The project is in the maven format, so it should be easy to import
 to popular IDE's such as Eclipse and Intellij.
 
 (Intellij note: Before you download, go to Preferences/Settings -> Build, Execution and Deployment -> Build Tools -> Maven -> Importing and select "Import Maven projects automatically")
 * All code you write should reside in the package no.uib.ii.inf102.f18.mandatory0
 * All code should have correct class names as according to the task specification
 
#### Register for the course at Kattis

 * You need to register an account at Kattis *whose username is your UiB SEBRA ID*.
 For instance, if your UiB id is *abc123*, you should create a user whose username
 is also *abc123*. If you already have a Kattis user, you can change your username
 by going to settings and change it there (you can change it back after the course
 has concluded and you have received your final grade in the course).
 * At https://uib.kattis.com/courses/INF102/fall18 you should click on 
 *I am a student taking this course and I want to register for it on Kattis*, and 
 enter the keyphrase *inf102kattis*.

#### Non-code answers

 * The answer to non-code questions should be contained in a single pdf named `String.format("%s.pdf", yourid)`
 where *yourid* is your UiB SEBRA account id handle (for example, if your UiB id is *abc123*,
 you should name the file `abc123.pdf`). The file should reside in the main folder of your maven project
 (that's the same folder as this README.md).
 

#### Submission

  * After solving the programming assignments and crafting the pdf with textual solutions,
  make a .zip file containing the main directory of your maven project.
  
    * The main directory of the zip file should be named identically to your UiB SEBRA
    account id (for example, if your UiB ID is *abc123*, then your main folder should
    also be named *abc123*).
  
    * The name of your zip file should be `String.format("%s.zip", yourid)`
 where *yourid* is your UiB SEBRA account id handle (for example, if your UiB id is *abc123*,
 you should name the file `abc123.zip`). 
 
    * To accomplish the two points above, it is easiest to copy the contents of your
    main directory to a new folder named *abc123*, and then zip that folder.
    
  * Submit the .zip file at the assignment on mitt.uib before the deadline
  
  * Late assignments will be accepted for 24 hours, with a 20 point penalty.


## Reverse Polish to Infix notation (10 points)

Solve the problem [Reverse Polish to Infix notation (easy)](https://uib.kattis.com/problems/uib.revpolishtoinfixeasy) on Kattis. You must *both* submit on Kattis, and also add your code to the maven project you are handing in. 

The problem is graded on both correctness and style. For this problem, there is no discussion part that goes into the pdf. There is, however, a 2 point bonus towards the assignment if your code is also able to beat [Reverse Polish to Infix notation (hard)](https://uib.kattis.com/problems/uib.revpolishtoinfixhard).


## Big-O Quiz (15 points)

Analysing runtimes of functions is hard work. In the file https://github.com/torsteins/inf102f18-lectures/blob/master/src/week35/BigOQuiz.java there is a bunch of functions you should analyse -- in
the pdf for the assignment, create a table 

Function |   f(n)  |   ~    |  O()
 :---: | --- | --- | ----
 `A`  |  2n + 1 |  ~2n | O(n)
 `B`  |   ...  |   ... | ...
 ... | ... | ... | ...
 `Z` | ... | ... | ...
 
 and fill in the blanks. To get full score, you must get the 24 functions B - Y correctly. The column for f(n) is the hardest column to fill, you need to be careful with rounding. There is a 2 point bonus if you get *everything* right, inluding `Z`.
 
 
 #### *Clarifications:*
  * *You may use the sum notation in your function f, for instance <a href="https://www.codecogs.com/eqnedit.php?latex=\sum_{i=0}^n&space;i^2" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\sum_{i=0}^n&space;i^2" title="\sum_{i=0}^n i^2" /></a>*
  * *For finding ~ and big-O, in can sometimes be useful to plug your formulae f into Wolphram Alpha (I'm looking at you, `M`).*
  * *In function `N`, the number of steps is non-deterministic. In this case, let your formula denote the worst case runtime.*
  * *In function `Y`, the number of steps is highly dependent on certain properties of the input. Let your formula f denote the worst case runtime for any input in the vicinity of `n`, ignoring that the funcion sometimes terminate earlier.*
 

## Union Find (15 points)

This problem is partially coding, and partially for the pdf. The coding problems (a and b) are graded on both correctness and style, and the code should be included in the maven project as well as submitted on Kattis.

 a) Solve the Kattis exercise [Fakebool QuickFind](https://uib.kattis.com/problems/uib.fakeboolquickfind) using a quick-find implementation whose union operation follows the convention that the lower id will always become the root.
 
 b) Solve the Kattis exercise [Fakebool UnionFind](https://uib.kattis.com/problems/uib.fakebool) using the union find data structure.
 
 c) In the solution for problem (b), is it possible to use weighted quick union? If yes, explain how you
 would do it, if not explain why it is not possible.
 
 d) Assume the following implementations of find and union in a UnionFind instance with `n` singleton elements.
```java
public int find(int p) {
    while (id[p] != p) p = id[p];
    return p;
}

public void union(int p, int q) {
    p = find(p);
    q = find(q);    
    id[p] = q;
}
```
Describe a scheme for making `m` calls to union and/or find such that the number of array accesses becomes maximum. Analyse how many array accesses will be made with your scheme as a function of `n` and `m`.


## Sortable Linked List (30 points)

Make a class `SortableLinkedList` which implements the interface `ISortableList`. We have already made a (silly) class `SortableArrayList` which also implements `ISortableList`; this is just for your reference, you do not need to touch it unless you really want to.

In addition to implementing the interface according to the natural specifications, we have some additional constraints your class needs to fulfill:

 * It must be based on a linked list - you may not use any form of array.
 * add(e) must take O(1) time
 * add(0, e) must take O(1) time
 * remove(0) must take O(1) time
 * sort() must take O(n log n) time (hint: merge sort)
 
When done, you must use write a client which utilize this data structure to solve the Kattis problem [Troll Book](https://uib.kattis.com/problems/uib.trollbook). You must *both* submit on Kattis, and also inclued your code to the maven project you are handing in. The problem is graded on both correctness and style. 
 
 Feel free to add JUnit test cases to test that your data structure works as expected.
 
#### *Clarifications:*
 * *You may use arrays of length no longer than O(log n), where n is the number of items in the list.*
 * *You must use the `sort()` algorithm of your class `SortableLinkedList` when solving Troll Book.*
 
 
 ##### Good luck!
