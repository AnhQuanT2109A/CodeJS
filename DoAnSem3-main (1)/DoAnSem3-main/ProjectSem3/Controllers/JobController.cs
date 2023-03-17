using Microsoft.AspNetCore.Mvc;

namespace ProjectSem3.Controllers
{
    public class JobController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
