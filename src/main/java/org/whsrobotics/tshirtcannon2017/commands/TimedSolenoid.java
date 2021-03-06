package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class TimedSolenoid extends TimedCommand {

    Solenoid solenoid;

    public TimedSolenoid(Solenoid solenoid, double timeout) {
        super(timeout);
        requires(Robot.pneumatics);
        this.solenoid = solenoid;
    }

    /**
     * The initialize method is called the first time this Command is run after being started.
     */
    @Override
    protected void initialize() {
        Pneumatics.setSingleSolenoid(solenoid, true);
    }

    /**
     * Called when the command ended peacefully. This is where you may want to wrap up loose ends,
     * like shutting off a motor that was being used in the command.
     */
    @Override
    protected void end() {
        Pneumatics.setSingleSolenoid(solenoid, false);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }
}
