public class Statistician extends OrderedList {

   public double getLargest(){
      double max=items[0];
      for(int i=1; i<count; i++){
         if(items[i]>max)
            max = items[i];
      }
      return max;
   }

   public double getSmallest(){
      double min=items[0];
      for(int i=1; i<count; i++){
         if(items[i]<min)
            min = items[i];
      }
      return min;
   }  

   public double getSum()
   {
      double sum=0;
   
      for (int i=0 ; i<count ; i++)
      {
         sum+= items[i];
      }
      return sum;
   }

   public double getMean()
   {
      return getSum()/count;
   }

   public double getMedian()
   {
        int median=0;
      double value=0;
      if(count%2==0){
         median = count/2;
         value = items[median-1]+items[median];
         value/=2;
      }
      else{
         median = count/2;
         value = items[median];
      }
         
      return value;
   }

   public void getMode(){
      int mode[] = new int[count];
      int c=0;
      int appear=0;
      int b=0;
      for(int i=0; i<count; i++){
         c=0;
         for(int j=0; j<count; j++){
            if(items[i]==items[j])
               c++;
         }
         if(c>1){
            if(c>appear){
               mode[0] = items[i];
               appear=c;
            }
         }
      }
      b++;
      for(int i=0; i<count; i++){
         c=0;
         for(int j=0; j<count; j++){
            if(items[i]==items[j])
               c++;
         }
         if(c>1){
            boolean isTrue=false;
            for(int k=0; k<b; k++){
               if(c==appear&&items[i]!=mode[k])
                  isTrue=true;
               else
                  isTrue=false;
            }
            if(isTrue)
               mode[b++]=items[i];
         }
      }
      System.out.print("Mode is ");
      for(int i=0; i<b; i++){
         System.out.print(mode[i]+" ");
      }
      System.out.println();
   }

   public static void main (String[] args)
   {
      Statistician stat = new Statistician();
   
      stat.add(1);
      stat.add(1);
      stat.add(3);
      stat.add(4);
      stat.add(5);
      stat.add(6);
      stat.add(7);
      stat.add(8);
      stat.add(9);
      stat.add(9);
      stat.add(10);
      
      System.out.println("list = " + stat );
      
      stat.remove(10);
      System.out.println("list = " + stat );
      
      System.out.println("Sum is " + stat.getSum());
      System.out.println("Smallest is " + stat.getSmallest());
      System.out.println("Largest is " + stat.getLargest());
      
      System.out.println("Mean is "+ stat.getMean());
      System.out.println("Median is "+ stat.getMedian());
      stat.getMode();
   }
}

