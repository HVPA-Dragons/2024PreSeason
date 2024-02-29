package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class ShooterModeCommand extends Command {
    private boolean shooterMode;

    public void execute() {
        shooterMode = !shooterMode;
    }

    public boolean getShooterMode() {
        return shooterMode;
    }

}
