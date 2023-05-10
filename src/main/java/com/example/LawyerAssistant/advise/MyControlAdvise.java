package com.example.LawyerAssistant.advise;

import com.example.LawyerAssistant.DTO.API;
import com.example.LawyerAssistant.DTO.ResponseAPI;
import com.example.LawyerAssistant.exceptions.*;
import org.hibernate.TransientPropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControlAdvise {


    Logger logger = LoggerFactory.getLogger(MyControlAdvise.class);

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> StudentNotFoundException(StudentNotFoundException e) {
        logger.info("StudentNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = MyClassNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> MyClassNotFoundException(MyClassNotFoundException e) {
        logger.info("MyClassNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> TeacherNotFoundException(TeacherNotFoundException e) {
        logger.info("TeacherNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = UserIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> UserIdNotFoundException(UserIdNotFoundException e) {
        logger.info("UserIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = SessionIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> SessionIdNotFoundException(SessionIdNotFoundException e) {
        logger.info("SessionIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = NoteIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> NoteIdNotFoundException(NoteIdNotFoundException e) {
        logger.info("NoteIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = UserIdDoesntHaveThisClassException.class)
    public ResponseEntity<ResponseAPI<?>> UserIdDoesntHaveThisClassException(UserIdDoesntHaveThisClassException e) {
        logger.info("UserIdDoesntHaveThisClassException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = CommentIdNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> CommentIdNotFoundException(CommentIdNotFoundException e) {
        logger.info("CommentIdNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = ClassIdIsNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> ClassIdIsNotFoundException(ClassIdIsNotFoundException e) {
        logger.info("ClassIdIsNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = YoureNotOwnerOfThisNoteException.class)
    public ResponseEntity<ResponseAPI<?>> YoureNotOwnerOfThisNoteException(YoureNotOwnerOfThisNoteException e) {
        logger.info("YoureNotOwnerOfThisNoteException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = YoureNotOwnerOfThisCommentException.class)
    public ResponseEntity<ResponseAPI<?>> YoureNotOwnerOfThisCommentException(YoureNotOwnerOfThisCommentException e) {
        logger.info("YoureNotOwnerOfThisCommentException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = NoRightsException.class)
    public ResponseEntity<ResponseAPI<?>> NoRightsException(NoRightsException e) {
        logger.info("NoRightsException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(401).body(new ResponseAPI<>(e.getMessage(),401));
    }


    @ExceptionHandler(value = ClassAlreadyRegisteredException.class)
    public ResponseEntity<ResponseAPI<?>> ClassAlreadyRegisteredException(ClassAlreadyRegisteredException e) {
        logger.info("ClassAlreadyRegisteredException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(403).body(new ResponseAPI<>(e.getMessage(),403));
    }

    @ExceptionHandler(value = YoureNotOwnerOfThisUserException.class)
    public ResponseEntity<ResponseAPI<?>> YoureNotOwnerOfThisUserException(YoureNotOwnerOfThisUserException e) {
        logger.info("YoureNotOwnerOfThisUserException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = UserNameFoundException.class)
    public ResponseEntity<ResponseAPI<?>> UsernameNotFoundException(UserIdNotFoundException e) {
        logger.info("UsernameNotFoundException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ResponseAPI<?>> IllegalStateException(IllegalStateException e) {
        logger.warn("IllegalStateException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = TransientPropertyValueException.class)
    public ResponseEntity<ResponseAPI<?>> TransientPropertyValueException(TransientPropertyValueException e) {
        logger.warn("TransientPropertyValueException => provoked!\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getPropertyName(),400));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<API> apiException(ApiException apiException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(apiException.getMessage(),400));
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<API> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException error){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error.getMessage(),400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> exception(Exception exception){
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("Server Error !",500));
    }

}
