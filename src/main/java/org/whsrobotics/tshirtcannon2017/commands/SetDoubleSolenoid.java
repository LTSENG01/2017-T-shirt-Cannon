package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class SetDoubleSolenoid extends InstantCommand {

    private DoubleSolenoid solenoid;
    private DoubleSolenoid.Value value;

    public SetDoubleSolenoid(DoubleSolenoid solenoid, DoubleSolenoid.Value value) {
        requires(Robot.pneumatics);
        this.solenoid = solenoid;
        this.value = value;
    }

    @Override
    protected void initialize() {
        Pneumatics.setDoubleSolenoid(solenoid, value);
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }
}
