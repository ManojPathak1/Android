package app.myapplication.com.reuz_app;

/**
 * Created by DELL PC on 22-Jul-16.
 */
public class CategoryItem {
    private String category_name;
    private int imageId;

    public CategoryItem(String category_name,int imageId)
    {
        this.category_name=category_name;
        this.imageId=imageId;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
