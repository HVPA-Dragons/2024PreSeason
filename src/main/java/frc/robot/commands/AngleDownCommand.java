package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterClimberSubsystem;

public class AngleDownCommand extends Command {
    private ShooterClimberSubsystem shooterClimberSubsystem;

    public AngleDownCommand(ShooterClimberSubsystem shooterClimberSubsystem) {
        this.shooterClimberSubsystem = shooterClimberSubsystem;

        addRequirements(shooterClimberSubsystem);
    }

    @Override
    public void execute() {
        shooterClimberSubsystem.AngleDown();
    }

    @Override
    public void end(boolean interrupted) {
        shooterClimberSubsystem.HoldAngle();

    }
}
