package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class StopCompressor extends InstantCommand {

    public StopCompressor() {
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        Pneumatics.stopCompressor();
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }

}
