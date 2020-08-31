/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DELL.SXO10
 */
public class Trie {
    
    
	static final int ALPHABETSIZE=70;
	static trie_node root= new trie_node();
	
	static class trie_node
	{
		public trie_node[]children=new trie_node[ALPHABETSIZE];
		public Boolean isendofword;
		public List<String>id= new ArrayList<>(); //id here is the path of file
		
		public trie_node()
		{
			// TODO Auto-generated constructor stub
			for(int i=0;i<ALPHABETSIZE;i++)
			{
				children[i]=null;
			}
			isendofword=false;
		}
	}
	
	 
    static void insert(String indexword,String y) 
    { 
         
        int index;        
        trie_node r = root; 
       
        for(int i=0;i<indexword.length();i++) 
        { 
        	if(Character.isDigit(indexword.charAt(i)))
                index = indexword.charAt(i) - '0'+27;
        	else if (indexword.charAt(i)=='\'')
        		index = 26;
                else if (indexword.charAt(i)=='+')
        		index = 37;
                else if (indexword.charAt(i)=='^')
        		index = 38;
                else if (indexword.charAt(i)=='’')
        		index = 39;
                 else if (indexword.charAt(i)=='–')
        		index = 40;
                 else if (indexword.charAt(i)=='-')
       		index = 41;
                 else if (indexword.charAt(i)=='=')
        		index = 42;
                 else if (indexword.charAt(i)=='\\')
        		index = 43;
//                 else if (indexword.charAt(i)=='[')
//        		index = 44;
//                 else if (indexword.charAt(i)==']')
//        		index = 45;
//                 else if (indexword.charAt(i)=='(')
//        		index = 46;
//                 else if (indexword.charAt(i)==')')
//        		index = 47;
//                 else if (indexword.charAt(i)=='{')
//        		index = 48;
//                 else if (indexword.charAt(i)=='}')
//        		index = 49;
//                 else if(indexword.charAt(i)=='!')
//                        index=50;
                 else if(indexword.charAt(i)=='ã')
                        index=51;
                 else if(indexword.charAt(i)=='é')
                        index=52;
                 else if(indexword.charAt(i)=='í')
                        index=53;
//                  else if(indexword.charAt(i)=='%')
//                        index=54;
//                  else if(indexword.charAt(i)=='?')
//                       index=55;
                  else if(indexword.charAt(i)=='ú')
                       index=60;
                  else if(indexword.charAt(i)=='á')
                      index=61;
                  else if(indexword.charAt(i)=='ج')
                     index=62;
                  else if(indexword.charAt(i)=='ز')
                     index=63;
//                  else if(indexword.charAt(i)=='×')
//                     index=64;
//                  else if(indexword.charAt(i)=='∪')
//                     index=65;
                  else if(indexword.charAt(i)=='−')
                       index=66;
//                  else if(indexword.charAt(i)=='_') 
//                      index=67;
                  else if(indexword.charAt(i)>='a'&&indexword.charAt(i)<='z')
                      index = indexword.charAt(i) - 'a';
                  else
                      continue;
           // System.out.println(indexword.charAt(i));
          //  System.out.println(index);
            if (r.children[index] == null) 
                r.children[index] = new trie_node(); 
       
           r = r.children[index]; 
        } 
       
        // mark last node as leaf(end of word)
        r.isendofword = true; 
        r.id.add(y);
    } 
    
 
    static List<String> search(String word) 
    { 
        word=word.toLowerCase();     
        trie_node r = root; 
       
        for (int i = 0; i < word.length(); i++) 
        { 
           int index;
           if(Character.isDigit(word.charAt(i)))
               index = word.charAt(i) - '0'+27;
       	else if (word.charAt(i)=='\'')
       		index = 26;
        else if (word.charAt(i)=='+')
               index = 37;
        else if (word.charAt(i)=='^')
               index = 38;
          else if (word.charAt(i)=='’')
        		index = 39;
          else if (word.charAt(i)=='–')
        		index = 40;
         else if (word.charAt(i)=='-')
        		index = 41;
          else if (word.charAt(i)=='=')
        		index = 42;
          else if (word.charAt(i)=='\\')
        		index = 43;
//          else if (word.charAt(i)=='[')
//        		index = 44;
//          else if (word.charAt(i)==']')
//        		index = 45;
//          else if (word.charAt(i)=='(')
//        		index = 46;
//          else if (word.charAt(i)==')')
//        		index = 47;
//          else if (word.charAt(i)=='{')
//        		index = 48;
//          else if (word.charAt(i)=='}')
//        	index = 49;
//          else if(word.charAt(i)=='!')
//                index=50;
          else if(word.charAt(i)=='ã')
                index=51;
          else if(word.charAt(i)=='é')
                index=52;
          else if(word.charAt(i)=='í')
                index=53;
//          else if(word.charAt(i)=='%')
//                     index=54;
//          else if(word.charAt(i)=='?')
//                     index=55;
          else if(word.charAt(i)=='ú')
              index=60;
          else if(word.charAt(i)=='á')
              index=61;
          else if(word.charAt(i)=='ج')
              index=62;
          else if(word.charAt(i)=='ز')
              index=63;
//          else if(word.charAt(i)=='×')
//                     index=64;
//          else if(word.charAt(i)=='∪')
//                     index=65;
          else if(word.charAt(i)=='−')
              index=66;
//          else if(word.charAt(i)=='_')
//                      index=67;
       	else if(word.charAt(i)>='a'&&word.charAt(i)<='z')
                      index = word.charAt(i) - 'a';
                  else
                      return r.id; 
          // System.out.println(word.charAt(i));
          // System.out.println(index);
            if (r.children[index] == null) 
            {
            	System.out.println("word is not found in this file"); // fel gui hant-check lw kant list fdya ytl3 lmsg dy
            	//r.id=null;
                return r.id;
            	
            }
            r = r.children[index]; 
        } 
        System.out.println(word+" could be found in "+r.id);
        return r.id;
    } 
}

