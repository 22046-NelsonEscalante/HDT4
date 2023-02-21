public class SLList<T> extends AbstractList<T> {

    private int count;
    private Node<T> start;
    private Node<T> end;

    public SLList() {
        count = 0;
        start = null;
        end = null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<T>(value, null);

        if (isEmpty())
        {
            start = newNode;
            end = newNode;
        }
        else
        {
            newNode.setNext(start);
            start = newNode;
        }
        count++;
	}

    @Override
	public T get(int index) {
		
	    if (!isEmpty())
        {
            if (index == 0)
            {
                return start.value();
            }
            else if (index == (size() - 1))
            {
                return end.value();
            }
            else if ((index > 0) && (index < (size() - 1)))
            {
                Node<T> temp = start;
                int i = 0;
                while ((temp != null) && (i != index))
                {
                    temp = temp.next();
                    i++;
                }

                if (temp != null)
                {
                    return temp.value();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }

        return null;
	}
    
    @Override
    public T delete(int index) {
		
		if (index == 0)
        {
            return deleteAtStart();
        }
        else if (index == (size() - 1))
        {
            return deleteAtEnd();
        }
        else if ((index > 0) && (index < (size() - 1)))
        {
            Node<T> pretemp = start;
            Node<T> temp = start.next();
            int i = 1;

            //Search the position where the node will be inserted
            while ((temp != null) && (i < (size() - 1)))
            {
                pretemp = temp;
                temp = temp.next();
                i++;
            }

            //Delete the node
            pretemp.setNext(temp.next());
            count--;
            return temp.value();
        }
        else
        {
            return null;
        }
	}

    @Override
	public T deleteAtStart() {
		
		if (!isEmpty()) 
        {
            Node<T> temp = start;
            start = start.next();
            count--;
            return temp.value();
        }

        return null;
	}

	@Override
	public T deleteAtEnd() {
		if (!isEmpty()) 
        {

            if (size() == 1) //Only one node then delete
            {
                Node<T> temp = start;
                start = null;
                end = null;
                count--;
                return temp.value();
            }
            else
            {
                Node<T> pretemp = start;
                Node<T> temp = start.next();

                //Search the position where the node will be inserted
                while (temp != null)
                {
                    pretemp = temp;
                    temp = temp.next();
                }

                //Delete the node
                end = pretemp;
                end.setNext(null);
                count--;
                return temp.value();
            }

        }

        return null;
    }
}
