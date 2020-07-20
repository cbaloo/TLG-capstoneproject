package leveldirection;

public enum Direction {

    NORTH,
    SOUTH,
    EAST,
    WEST;

    /* CB-Using NOEXIT with an integer value when initializing the 'EXIT' fields in Level objects.

    Valid Exits indicate a level number and NOEXIT is -1.
     */

    public  static final int NOEXIT = -1;
};
