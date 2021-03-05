package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.subsystems.Indexer;

public class StageFive extends CommandBase {
    private final Indexer indexer = Indexer.getInstance();

    public StageFive() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
        indexer.setSpeedFive(0.5);
        indexer.setSpeedFour(-0.5);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished(){
        return indexer.getState()[5];
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.setSpeedFive(0);
        indexer.setSpeedFour(0);
    }
}
