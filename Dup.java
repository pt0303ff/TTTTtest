package demo;
import ds.ArrayTool_f;
import ds.*;

class Dup {

   static float[] fA= {10.0f, 11.0f, 12.0f};

   static void revL_L(LList_f L) { 
      System.out.println("\n --- RevL_L ---");
      System.out.println(L);
      for(Iter_f i=L.iter(); i.isValid(); i.toNext()) {
         float d= i.getData();
         L.prepend(d);  i.incIndex();
         System.out.println("// @"+i.getIndex()+"  "+L);
      } 
      System.out.println(L); 
      System.out.println("0130================"); 
   }
/*
 --- RevL_L ---
 S[ 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// @1   S[ 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// @3   S[ 11.0, 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// @5   S[ 12.0, 11.0, 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// @7   S[ 13.0, 12.0, 11.0, 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// @9   S[ 14.0, 13.0, 12.0, 11.0, 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
 S[ 14.0, 13.0, 12.0, 11.0, 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
*/

   static void dupL_L(LList_f L) { 
      System.out.println("\n --- dupL_L ---");
      System.out.println(L);
      List_f.iterHandleAt= true;
      Iter_f k= L.iter();
      List_f.iterHandleAt= false;
      for(Iter_f i=L.iter(); i.isValid(); i.toNext()) {
         float d= i.getData();
         k.insAt(d);  i.incIndex();  
           //: k always point to the original head
         System.out.println(
            "// k@"+k.getIndex() +" i@"+i.getIndex() +" "+L
         );
      } 
      System.out.println(L); 
   }
/*
 --- dupL_L ---
 S[ 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// k@1 i@1  S[ 10.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// k@2 i@3  S[ 10.0, 11.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// k@3 i@5  S[ 10.0, 11.0, 12.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// k@4 i@7  S[ 10.0, 11.0, 12.0, 13.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// k@5 i@9  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
 S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
*/

   static void L_revL(LList_f L) { 
      System.out.println("\n --- L_revL ---");
      System.out.println(L);
      Iter_f k=L.tailIter();
      for(Iter_f i=L.iter(); i.isValid() && i.le(k); i.toNext()) {
         float d= i.getData();
         k.insAfter(d);  
         System.out.println(
            "// i@"+i.getIndex() +" k@"+k.getIndex() +" "+L
         );
      } 
      System.out.println(L); 
   }
/*
 --- L_revL ---
 S[ 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// i@0 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0,  ]
// i@1 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 11.0, 10.0,  ]
// i@2 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 12.0, 11.0, 10.0,  ]
// i@3 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 13.0, 12.0, 11.0, 10.0,  ]
// i@4 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 14.0, 13.0, 12.0, 11.0, 10.0,  ]
 S[ 10.0, 11.0, 12.0, 13.0, 14.0, 14.0, 13.0, 12.0, 11.0, 10.0,  ]
*/

   static void L_dupL(LList_f L) { 
      System.out.println("\n --- L_dupL ---");
      System.out.println(L);
      for(Iter_f i=L.iter(), b=L.tailIter(), k=b.duplicate(); 
          i.isValid() && i.le(b); 
          i.toNext(), k.toNext()) 
      {
         float d= i.getData();
         k.insAfter(d);  
         System.out.println(
            "// i@"+i.getIndex() +" k@"+k.getIndex() +" "+L
         );
      } 
      System.out.println(L); 
   }
/*
 --- L_dupL ---
 S[ 10.0, 11.0, 12.0, 13.0, 14.0,  ]
// i@0 k@4  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0,  ]
// i@1 k@5  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0,  ]
// i@2 k@6  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0,  ]
// i@3 k@7  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0, 13.0,  ]
// i@4 k@8  S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
 S[ 10.0, 11.0, 12.0, 13.0, 14.0, 10.0, 11.0, 12.0, 13.0, 14.0,  ]
*/

   public static void main(String[] dummy) {
      List_f.showListType=true;
      revL_L(List_f.create_SL(fA));  System.out.println(); 
      dupL_L(List_f.create_SL(fA));  System.out.println(); 
      L_revL(List_f.create_SL(fA));  System.out.println(); 
      L_dupL(List_f.create_SL(fA));  System.out.println(); 
   }

}
