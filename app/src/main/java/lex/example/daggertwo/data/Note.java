package lex.example.daggertwo.data;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by lex on 2/5/15.
 */

@Table
public class Note extends BaseModel {

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_BODY = "body";
    public static final String COLUMN_NAME_CREATED = "created";

    @Column(name = COLUMN_NAME_ID, columnType = Column.PRIMARY_KEY_AUTO_INCREMENT)
    Long id;

    @Column(name = COLUMN_NAME_TITLE)
    String title;

    @Column(name = COLUMN_NAME_BODY)
    String body;

    @Column(name = COLUMN_NAME_CREATED)
    String created;

    public Note() { }

    public Note(String title, String body, String created) {
        this.title = title;
        this.body = body;
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;

        final Note note = (Note) o;

        if (created != null ? !created.equals(note.created) : note.created != null) return false;
        if (body != null ? !body.equals(note.body) : note.body != null) return false;
        if (title != null ? !title.equals(note.title) : note.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
