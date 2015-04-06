package uk.co.tombooth.positionmidi;


public class Motion {

    public class Dimensional {
        public double x;
        public double y;
        public double z;
    }

    public class Attitude {
        public double pitch;
        public double yaw;
        public double roll;
    }

    public Attitude attitude;
    public Dimensional rotationRate;
    public Dimensional gravity;
    public Dimensional userAcceleration;
    public Dimensional magneticField;

}
