package org.whsrobotics.tshirtcannon2017.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.whsrobotics.tshirtcannon2017.commands.DriveManual;
import org.whsrobotics.tshirtcannon2017.robot.RobotMap;

public class DriveTrain extends Subsystem {

    private static DriveTrain instance;

    private static CANTalon frontLeftTalon;
    private static CANTalon frontRightTalon;
    private static CANTalon backLeftTalon;
    private static CANTalon backRightTalon;

    private static RobotDrive robotDrive;

    private DriveTrain() {
        frontLeftTalon = new CANTalon(RobotMap.DRIVE_FRONT_LEFT_TALON_PORT);
        frontRightTalon = new CANTalon(RobotMap.DRIVE_FRONT_RIGHT_TALON_PORT);
        backLeftTalon = new CANTalon(RobotMap.DRIVE_BACK_LEFT_TALON_PORT);
        backRightTalon = new CANTalon(RobotMap.DRIVE_BACK_RIGHT_TALON_PORT);

        robotDrive = new RobotDrive(frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon);
    }

    /**
     * Initialize the default command for a subsystem By default subsystems have no default command,
     * but if they do, the default command is set with this method. It is called on all Subsystems by
     * CommandBase in the users program after all the Subsystems are created.
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveManual());
    }

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    public void manualDrive(double x, double y, boolean sensitiveDrive) {
        robotDrive.arcadeDrive(x, y, sensitiveDrive);
    }

    public void stopDrive() {
        robotDrive.stopMotor();
    }

}
