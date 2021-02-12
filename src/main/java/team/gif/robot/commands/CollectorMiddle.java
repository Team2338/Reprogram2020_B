package team.gif.robot.commands;

import team.gif.robot.subsystems.Collector;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class CollectorMiddle extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Collector collector = Collector.getInstance();

    /**
     * Creates a new ExampleCommand.
     *
     */
    public CollectorMiddle() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        collector.setSolenoids(false, true, false);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
}