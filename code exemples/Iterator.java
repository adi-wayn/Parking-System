import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


interface SnakeReader {
    boolean hasNext();
    String next();
}

class SimpleSnakeReader implements SnakeReader {

    private final String snake;
    private boolean used = false;

    public SimpleSnakeReader(String snake) {
        this.snake = snake;
    }

    @Override
    public boolean hasNext() {
        return !used;
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        used = true;
        return snake;
    }
}

class SnakeHolder {

    private String snake;

    public void setSnake(String snake) {
        this.snake = snake;
    }

    public SnakeReader Reader() {
        return new SimpleSnakeReader(snake);
    }
}











interface SnakeReader {
    boolean hasNext();
    String next();
}

class SimpleSnakeReader implements SnakeReader {

    private final List<String> snakes;
    private int index = 0;

    public SimpleSnakeReader(List<String> snakes) {
        this.snakes = snakes;
    }

    @Override
    public boolean hasNext() {
        return index < snakes.size();
    }

    @Override
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        return snakes.get(index++);
    }
}

class SnakeCollection {

    private List<String> snakes = new ArrayList<>();

    public void addSnake(String snake) {
        if (snake != null) {
            snakes.add(snake);
        }
    }

    public SnakeReader Reader() {
        return new SimpleSnakeReader(snakes);
    }
}