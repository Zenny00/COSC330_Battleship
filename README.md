Github repository for COSC330 Battleship Project I
by Joshua Comfort and Justin Conklin
created Fall 2022

Summary: This program allows users connected over a LAN network to play a game of battleship.
Rules for the game can be found here: https://www.hasbro.com/common/instruct/battleship.pdf 


To compile program:
    ensure all files are included and in File List format given below
    in terminal: javac Battleship.java

To run program:
    As Server: java Battleship Server
    As Client: java Battleship Client

File List:
* README.md
* BattleshipUML.png

* Controller folder
    Battleship.java
    Player.java
    Role.java
    Server.java
    Client.java

* View folder
    -> ActionListener folder
        ...
    -> Graphics folder
        ...
    View.java

* Model folder
    Board.java
    Model.java
    Ship.java
    ShipBoard.java
    Tile.java

Dependencies:
    Java JDK (17+)