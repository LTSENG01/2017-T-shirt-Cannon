package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.tshirtcannon2017.robot.OI;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.utils.XboxController;

public class DriveManual extends Command {

    public DriveManual() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Beginning to drive");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.manualDrive(
                OI.xboxController.getRawAxis(XboxController.Axes.LEFT_Y),
                OI.xboxController.getRawAxis(XboxController.Axes.RIGHT_X),
                true);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}