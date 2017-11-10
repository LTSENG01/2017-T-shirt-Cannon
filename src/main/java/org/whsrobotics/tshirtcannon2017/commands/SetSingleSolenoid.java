package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class SetSingleSolenoid extends InstantCommand {

    private Solenoid solenoid;
    private boolean state;

    public SetSingleSolenoid(Solenoid solenoid, boolean state) {
        requires(Robot.pneumatics);
        this.solenoid = solenoid;
        this.state = state;
    }

    @Override
    protected void initialize() {
        Pneumatics.setSingleSolenoid(solenoid, state);
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }
}
