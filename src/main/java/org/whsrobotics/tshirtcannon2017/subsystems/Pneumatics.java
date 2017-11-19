package org.whsrobotics.tshirtcannon2017.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.whsrobotics.tshirtcannon2017.robot.RobotMap;

public class Pneumatics extends Subsystem {

    private static Compressor compressor;
    private static Solenoid sprinklerValveSolenoid;
    private static Solenoid frontChamberSolenoid;
    private static Solenoid chargeCannonTankSolenoid;
    private static Solenoid shellEjectorSolenoid;

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
        compressor = new Compressor(RobotMap.PNEU_COMPRESSOR_PORT);
        sprinklerValveSolenoid = new Solenoid(RobotMap.PNEU_SPRINKLER_VALVE_SOL_PORT);
        frontChamberSolenoid = new Solenoid(RobotMap.PNEU_FRONT_CHAMBER_SOL_PORT);
        shellEjectorSolenoid = new Solenoid(RobotMap.PNEU_SHELL_EJECTOR_SOL_PORT);
        chargeCannonTankSolenoid = new Solenoid(RobotMap.PNEU_CHARGE_CANNON_SOL_PORT);

        compressor.setClosedLoopControl(false);
        setSingleSolenoid(sprinklerValveSolenoid, false);
        setSingleSolenoid(frontChamberSolenoid, false);
        setSingleSolenoid(shellEjectorSolenoid, false);
        setSingleSolenoid(chargeCannonTankSolenoid, false);
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

    public static Solenoid getChargeCannonTankSolenoid() {
        return chargeCannonTankSolenoid;
    }

    public static Solenoid getShellEjectorSolenoid() {
        return shellEjectorSolenoid;
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
