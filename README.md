![Dependency Logo](https://github.com/mirllamarques/Dependency-Install/assets/56745829/23e30080-8ab1-4e22-989c-e69d1007a903)

Welcome to Dependency Install, your dependency installation assistant. I will guide you how to install me to help your projects

1. I'm a Java Program, so you need Java 11 already installed. Chech it out <a href="https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html">here</a>

2. Click on Code and Download Zip or open it in Github Desktop

3. Open the folder in your favorite IDE

Some tips about how the inputs/outputs works:

~~~java
Welcome to Dependency Install, your dependency installation assistent 
How can I help you?
1- Get new project's dependencies
2- Finish
1

What is your project's name?

Project X

What is your project's dependencies? (Split with comma)

A,B,C,D,E

Now you will tell me which dependency depends on which
If any dependency has no associated dependencies just press Enter
Which are the dependency of A? (Split with comma)
B,C
Which are the dependency of B? (Split with comma)

Which are the dependency of C? (Split with comma)

Which are the dependency of D? (Split with comma)
E
Which are the dependency of E? (Split with comma)

Here is an order to install Project X's dependencies:

[B, C, A, E, D]
~~~

