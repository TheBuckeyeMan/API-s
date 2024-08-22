package base.template.template.api.model;


//entire purpose of the model is to map what we believe the response will be
public class Model {
    //Add all values we expect to see in the response and data types
    private String placeholder;

    //Constructor - Add all additional data points
    public Model(String placeholder){
        this.placeholder = placeholder;
    }

    //Getters - Add for all Data Points
    public String getPlaceholder(){
        return placeholder;
    }

    //Setters - Add for all Data Points
    public void setPlaceholder(String placeholder){
        this.placeholder = placeholder;
    } 
}
