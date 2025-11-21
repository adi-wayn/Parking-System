interface Runner {
    void run();
}

class Cheetah implements Runner {
    @Override
    public void run() {
        System.out.println("Cheetah running fast!");
    }
}

class CheetahService implements Runner {
    private Cheetah cheetah = new Cheetah();

    @Override
    public void run() {
        cheetah.run();
    }
}






interface Mover {
    void move();
}

class Snail {
    public void crawlSlowly() {
        System.out.println("Snail crawling slowly...");
    }
}

class SnailService implements Mover {
    private Snail snail;

    public SnailService(Snail snail) {
        this.snail = snail;
    }

    @Override
    public void move() {
        snail.crawlSlowly();
    }
}