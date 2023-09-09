package ch13.sec02.exam01;

public class Product<K, M> {

    private K kind; // 제네릭 타입
    private M model; // 제네릭 모델 타입

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
