package edu.pepcoding.tree.generic_tree;

import java.util.Stack;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/levelorder-linewise-zigzag-official/ojquestion
// https://www.youtube.com/watch?v=eDdPZ05y4Os&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=17
public class LevelorderLinewiseZigZag {

  public static void levelOrderLinewiseZZ(Node node){
    Stack<Node> ms = new Stack<>();
    Stack<Node> cs = new Stack<>();
    ms.push(node);

    boolean isLeftToRight = true;

    while(!(ms.isEmpty() && cs.isEmpty())){

      if( ms.isEmpty()){
        System.out.println();
        isLeftToRight = !isLeftToRight;
        ms = cs;
        cs = new Stack<>();
      }else{
        Node peek = ms.pop();
        System.out.print(peek.data+" ");
        if(isLeftToRight){
          for(int i=0; i<=peek.children.size()-1; i++){
            cs.push(peek.children.get(i));
          }
        }else {
          for(int i=peek.children.size()-1; i>=0; i--){
            cs.push(peek.children.get(i));
          }
        }
      }
    }
  }
}
