import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count;

    void clear() {
        if (count > 0) {
            Arrays.fill(storage, 0, count, null);
            count = 0;
        }
    }

    void save(Resume r) {
        if (r != null) {
            storage[count] = r;
            count++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                count--;
                System.arraycopy(storage, i + 1, storage, i, count - i);
                storage[count] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return count;
    }
}