package org.whsrobotics.tshirtcannon2017.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.whsrobotics.tshirtcannon2017.robot.Robot;
import org.whsrobotics.tshirtcannon2017.subsystems.Pneumatics;

public class StartCompressor extends InstantCommand {

    public StartCompressor() {
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        System.out.println("Start compressor!");
        Pneumatics.startCompressor();
    }

    @Override
    protected boolean isFinished() {
        return super.isFinished();
    }

}
