package edu.interview_bit.stacks_and_queues;

import java.util.Stack;

public class SimplifyDirectoryPath {

  public String simplifyPath(String str) {
    Stack<String> stack = new Stack<>();
    String[] dirs = str.split("/");
    for(int i=0; i<dirs.length; i++){
      if(dirs[i].trim().length()==0 || dirs[i].equals(".")){
        continue;
      }
      if(dirs[i].equals("..")){
        if(!stack.isEmpty()){
          stack.pop();
        }
      }else{
        stack.push(dirs[i]);
      }
    }

    StringBuilder path = new StringBuilder();
    for(String s : stack){
      path.append("/").append(s);
    }
    if(path.length()==0){
      path.append("/");
    }

    return path.toString();
  }

}
