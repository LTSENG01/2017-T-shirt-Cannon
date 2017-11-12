package org.whsrobotics.tshirtcannon2017.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

    private static Compressor compressor;
    private static Solenoid sprinklerValveSolenoid;
    private static Solenoid frontChamberSolenoid;

    private static Pneumatics instance;

    private Pneumatics() {
        init();
    }

    public static Pneumatics getInstance() {
        if (instance == null) {
            instance = new Pneumatics();
        }
        return instance;
    }

    /**
     * Initialize the default command for a subsystem By default subsystems have no default command,
     * but if they do, the default command is set with this method. It is called on all Subsystems by
     * CommandBase in the users program after all the Subsystems are created.
     */
    @Override
    protected void initDefaultCommand() {

    }

    public static void init() {
        compressor = new Compressor(0);
        sprinklerValveSolenoid = new Solenoid(1);
        frontChamberSolenoid = new Solenoid(0);

        compressor.setClosedLoopControl(false);
        setSingleSolenoid(sprinklerValveSolenoid, false);
        setSingleSolenoid(frontChamberSolenoid, false);
    }

    public static boolean getCompressorState() {
        return compressor.enabled();
    }

    public static double getCompressorCurrent() {
        return compressor.getCompressorCurrent();
    }

    public static void startCompressor() {
        compressor.start();
    }

    public static void stopCompressor() {
        compressor.stop();
    }

    public static boolean getPressureSwitchState() {
        return compressor.getPressureSwitchValue();
    }

    public static Solenoid getSprinklerValveSolenoid() {
        return sprinklerValveSolenoid;
    }

    public static Solenoid getFrontChamberSolenoid() {
        return frontChamberSolenoid;
    }

    public static void setSingleSolenoid(Solenoid solenoid, boolean state) {
        System.out.println(solenoid.get());
        solenoid.set(state);
    }

    // We don't actually use a DoubleSolenoid
    public static void setDoubleSolenoid(DoubleSolenoid doubleSolenoid, DoubleSolenoid.Value value) {
        doubleSolenoid.set(value);
    }

}
