const Modal = ({ show, onCloseButtonClick, text}) => {
    if (!show) {
        return null;
    }

    return (
        <div className="modal-wrapper">
            <div className="modal">
                <div className="body">
                    {text}
                </div>
                <div className="footer">
                    <button onClick={onCloseButtonClick}>Close Modal</button>
                </div>
            </div>
        </div>
    );
};

export default Modal;
