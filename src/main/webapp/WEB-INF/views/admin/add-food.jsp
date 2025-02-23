<form action="/food/add" method="post" enctype="multipart/form-data">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required><br>

    <label for="category_id">Category:</label>
    <input type="number" id="category_id" name="category_id" required><br>

    <label for="img">Image:</label>
    <input type="file" id="img" name="img" accept="image/*" required><br>

    <button type="submit">Add Product</button>
</form>
