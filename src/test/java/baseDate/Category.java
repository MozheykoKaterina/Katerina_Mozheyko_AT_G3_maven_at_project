package baseDate;

import java.util.Objects;

public class Category {
    
    int categoryID;
    String categoryName;
    String description;
    
    public Category(int categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryID == category.categoryID && Objects.equals(categoryName, category.categoryName) && Objects.equals(description, category.description);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(categoryID, categoryName, description);
    }
}