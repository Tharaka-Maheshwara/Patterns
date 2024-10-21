//Behavioral Patterns
//State Pattern

interface State {
    void handle(TrafficLightContext context);
}

class RedLightState implements State {
    public void handle(TrafficLightContext context) {
        System.out.println("Red Light - Stop");
        context.setState(new GreenLightState());
    }
}

class GreenLightState implements State {
    public void handle(TrafficLightContext context) {
        System.out.println("Green Light - Go");
        context.setState(new YellowLightState());
    }
}

class YellowLightState implements State {
    public void handle(TrafficLightContext context) {
        System.out.println("Yellow Light - Slow Down");
        context.setState(new RedLightState());
    }
}

class TrafficLightContext {
    private State state;

    public TrafficLightContext() {

        state = new RedLightState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }

    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();
        context.request(); // Red to Green
        context.request(); // Green to Yellow
        context.request(); // Yellow to Red
    }
}
