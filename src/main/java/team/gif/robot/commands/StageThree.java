package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.subsystems.Indexer;

public class StageThree extends CommandBase {
    private final Indexer indexer = Indexer.getInstance();

    public StageThree() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
        indexer.setSpeedThree(0.5);
        indexer.setSpeedTwo(0.5);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished(){
        if ((indexer.getState()[3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.setSpeedThree(0);
        indexer.setSpeedTwo(0);
    }
}
