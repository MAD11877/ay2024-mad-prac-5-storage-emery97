package sg.edu.np.mad.madpractical5;

public class User {
    public String name, description;
    public int id;
    public boolean followed;

    public User(){}
    public User(String name, String description, boolean followed) {
        this.name = name;
        this.description = description;
        this.followed = followed;
    }

    // Getter methods
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getId() { return id; }
    public boolean getFollowed() { return followed; }

    // Setter methods
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setId(int id) { this.id = id; }
    public void setFollowed(boolean followed) { this.followed = followed; }
}
