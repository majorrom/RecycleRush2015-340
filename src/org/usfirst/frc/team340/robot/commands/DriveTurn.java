package org.usfirst.frc.team340.robot.commands;

/**
 * Command which will autonomously turn the robot until it has rotated for a given distance.
 * @author Jakob W.
 */
public class DriveTurn extends CommandBase {

    private double speed;
	private double rotate;
	private double distance;

	public DriveTurn(double speed, double rotate, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.speed = speed;
    	this.rotate = rotate;
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[DriveTurn: initialize] reset drive encoder");
    	//XXRJPXX Let's avoid this. Use deltas
    	drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[DriveTurn: execute] arcade drive at speed and rotating");
    	drive.arcadeDrive(speed, rotate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//XXRJPXX Only works if distance is positive. Should be alright as long as we keep that in mind.
    	return ((Math.abs(drive.leftEncoderDistance()) >= distance) || (Math.abs(drive.rightEncoderDistance()) >= distance));
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[DriveTurn: end] stop moving");
    	drive.setLeftRightMotorOutputs(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[DriveTurn: interrupted] stop moving");
    	drive.setLeftRightMotorOutputs(0.0, 0.0);
    }
}
