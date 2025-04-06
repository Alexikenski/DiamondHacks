/**
 * Holds product information
 */

public class ProductInfo{
    private String name;
    private Double price;
    private String imageFileName;
    private String description;
    private String Category;
    private final String seperator = ";;.##";

    /**
     * Constructor that initializes values and checks for null values as well
     * @param name 
     * @param price
     * @param imageFileName
     * @param description
     * @param Category
     */
    public ProductInfo(String name, Double price, String imageFileName, String description, String Category){
        if (name == null || price == null || imageFileName == null || description == null || Category == null){
            throw new NullPointerException("Invalid implementation of Product Info");
        }

        this.name = name;
        this.price = price;
        this.imageFileName = imageFileName;
        this.description = description;
        this.Category = Category;
    }

    /**
     * Separates data using delimiters
     * @param dataString - the String to separate
     */
    public ProductInfo(String dataString){
        if (dataString.contains("{")){
            dataString = dataString.substring(1, dataString.length());
        }
        if (dataString.contains("}")){
            dataString = dataString.substring(0, dataString.length() - 1);
        }
        String[] seperate = dataString.split(seperator);
        if (seperate.length != 1){
            name = seperate[0];
            price = Double.parseDouble(seperate[1]);
            imageFileName = seperate[2];
            description = seperate[3];
            for (int i = 0; i < seperate[4].length() - 5; i++){
                if (seperate[4].substring(i, i + 4).equals("}'@#%")){
                    seperate[4] = seperate[4].substring(i, i + 4);
                }
            }
            Category = seperate[4];
        }
    }

    // gets the information for each category
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory(){
        return Category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setImageFileName(String imageFileName){
        this.imageFileName = imageFileName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(String Category){
        this.Category = Category;
    }

    /**
     * Overrides the default toString method
     * @return the information as a String
     */
    @Override
    public String toString(){
        if (this.name == null){
            return "";
        }
        return "{" + name + seperator + price + seperator + imageFileName + seperator + description + seperator + Category + "}";
    }
}