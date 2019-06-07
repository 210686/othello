import java.util.ArrayList;
public class printResult{
    /* private fields */
    private ArrayList<Result> resArr = new ArrayList<Result>();
    
    /* Initialize contructor */
    public printResult(){}
    
    /* Add a new Result into resArr */
    public void addResult(Result res){
        resArr.add(res);
    }
    
    /* Prints the contents of resArr */
    public void printConsole(){
        System.out.print("\f");
        for(int i = 0; i < resArr.size(); i++){
            System.out.println(resArr.get(i).toString());
        }
    }
}