package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterClimberSubsystem;

public class StartupZeroCommand extends Command {
    private ShooterClimberSubsystem shooterClimberSubsystem;

    public StartupZeroCommand(ShooterClimberSubsystem shooterClimberSubsystem) {
        this.shooterClimberSubsystem = shooterClimberSubsystem;

        addRequirements(shooterClimberSubsystem);
    }

    @Override
    public void execute() {
        shooterClimberSubsystem.startupZero();
    }

    @Override
    public void end(boolean interrupted) {
    }

}
