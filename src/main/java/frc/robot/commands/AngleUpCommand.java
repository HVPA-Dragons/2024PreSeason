package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterClimberSubsystem;

public class AngleUpCommand extends Command {
    private ShooterClimberSubsystem shooterClimberSubsystem;

    public AngleUpCommand(ShooterClimberSubsystem shooterClimberSubsystem) {
        this.shooterClimberSubsystem = shooterClimberSubsystem;

        addRequirements(shooterClimberSubsystem);
    }

    @Override
    public void execute() {
        shooterClimberSubsystem.AngleUp();
    }

    @Override
    public void end(boolean interrupted) {
        shooterClimberSubsystem.HoldAngle();

    }
}
