# Rat_Across_Desert_Array

Program Overview/Functions:

If the rat tries to leave the maze by exiting one of the edge cells, across the edge, it stays in that cell until it moves again but also wears down or refreshes by one unit. 

When a rat dies the control driver decides if a new rat must then brave the desert from the beginning location [0][0](cell notifies desert, desert notifies control and control starts the process to create a new Rat).  

Count how many rats it takes to find a safe path across the desert from beginning to the end.  List the path that was successful. The path is provided by the desert which kept track of the rat’s progress or by the rat that successfully crosses the desert. 

Each cell also has a “grave yard” (ArrayList<RatInteface>) to hold the rats that died while in the custody of that cell. 
  
Since all cells inherit the Cell class, the Cell class should implement the storage and the methods that control the Rat graveyard. The Cell class should also implement the storage and the methods of storing rats between moves. 
  
Allow the user to repeat the program with a new desert, choosing the size of the two-dimensional array again. 
