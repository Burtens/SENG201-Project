public class Fertilizer implements Items {
     private String type;
     private String description;


     Fertilizer(String type)
     {
         try
         {
             if (type != "growth" || type != "value")
                 throw new IllegalTypeException(type);
             else
                setType(type);
         }
         catch (IllegalTypeException e)
         {
             System.out.println(e);
             System.out.println("Automatically giving item type: 'growth'");
             setType("growth");
         }

     }

     private void setType(String type){
         this.type = type;
         if (this.type == "growth")
             this.description = "This fertilizer will double the growth rate of your crops.";
         else
             this.description = "This fertilizer will increase the value of your crops.";
     }

     public String getType()
     {
         return this.type;
     }

     public String getDescription()
     {
         return this.description;
     }
}
