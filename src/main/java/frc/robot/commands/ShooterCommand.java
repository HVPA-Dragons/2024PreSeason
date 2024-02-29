package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterClimberSubsystem;

public class ShooterCommand extends Command {

    private final ShooterClimberSubsystem shooterClimberSubsystem;
    private final boolean shooterMode;

    public ShooterCommand(ShooterClimberSubsystem shooterClimberSubsystem, boolean shooterMode) {
        this.shooterClimberSubsystem = shooterClimberSubsystem;
        this.shooterMode = new ShooterModeCommand().getShooterMode();
        addRequirements(shooterClimberSubsystem);
    }

    @Override
    public void execute() {
        if (shooterMode == true) {
            shooterClimberSubsystem.shootOnSpeaker();
        } else {
            shooterClimberSubsystem.shootOnAmp();
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooterClimberSubsystem.stopShooter();
    }
}